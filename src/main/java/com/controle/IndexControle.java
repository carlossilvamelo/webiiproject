package com.controle;


import com.IServicos.DiscenteLocal;
import com.IServicos.DocenteLocal;
import com.IServicos.UsuarioLocal;
import com.dominio.Discente;
import com.dominio.Docente;
import com.dominio.Usuario;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.logging.Logger;


@Named
@RequestScoped
public class IndexControle implements Serializable {
    static final Logger LOG = Logger.getLogger(IndexControle.class.getName());

    private String cpf;
    private String senha;
    private boolean erro;

    @EJB
    private DiscenteLocal discenteLocal;
    @EJB
    private DocenteLocal docenteLocal;
    @EJB
    private UsuarioLocal usuarioLocal;

    public IndexControle() {
    }


    public String identificarUsuario(){
        LOG.info("CPF: "+this.cpf);
        LOG.info("Senha: "+this.senha);
        String retorno = "";
        Usuario usuario = null;

        usuario = usuarioLocal.buscarPorCpf(this.cpf);

        if(usuario != null){


            if(usuario.getIdentificacao().getSenha().equals(getSenha())){
                //autenticado
                if(usuario.getTipo().equals("Discente")){

                    //buscar o objeto discente
                    Discente discente = discenteLocal.buscarPorId(usuario.getId());

                    if(discente != null){

                        FacesContext.getCurrentInstance().getExternalContext()
                                .getSessionMap().put("discente", discente);
                    }
                    retorno = "/layout-aluno/index-aluno?faces-redirect=true";
                }else{
                    //buscar o objeto docente
                    Docente docente = docenteLocal.buscarPorId(usuario.getId());
                    LOG.info(docente.getNome());
                    if(docente != null){

                        FacesContext.getCurrentInstance().getExternalContext()
                                .getSessionMap().put("docente", docente);
                    }

                    retorno = "/layout-professor/index-professor?faces-redirect=true";
                }

            }else{
                setErro(true);
                retorno = "index";
            }




        }else{
            setErro(true);
            retorno = "index";
        }

        return retorno;
    }



    public String logout(){
        System.out.println("LOGOUT");
        return "#{request.contextPath}/index?faces-redirect=true";
    }




    /* getters and setters */

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isErro() {
        return erro;
    }

    public void setErro(boolean erro) {
        this.erro = erro;
    }
}
