package com.controle;

import com.IServicos.DiscenteLocal;
import com.IServicos.UsuarioLocal;
import com.dominio.Discente;
import com.dominio.Usuario;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Named
@RequestScoped
public class ContatosDiscenteControle implements Serializable{
    static final Logger LOG = Logger.getLogger(ContatosDiscenteControle.class.getName());

    private Discente discenteSessao;

    @EJB
    private UsuarioLocal usuarioLocal;
    @EJB
    private DiscenteLocal discenteLocal;


    public ContatosDiscenteControle() {
        this.discenteSessao = (Discente) FacesContext.getCurrentInstance()
                .getExternalContext().getSessionMap().get("discente");
    }

    public List<Usuario> listarContatos(){

        return discenteSessao.getContatos();
    }

    public List<Usuario> listarTodosUsuarios(){
        List<Usuario> listaTodos = usuarioLocal.listarTodos();
        List<Usuario> nova = new ArrayList<Usuario>();
        if(this.discenteSessao.getContatos() != null) {

            for (Usuario usu : listaTodos) {

                Boolean exist = false;
                for (Usuario contato : this.discenteSessao.getContatos()) {
                    if (usu.getId() == contato.getId()) {
                        exist = true;
                    }
                }

                if(!exist)
                    nova.add(usu);
            }

        }else{
            nova = listaTodos;
        }

        return nova;
    }

    public List<Usuario> filtarListaUsuariosPorLogin(){

        return null;
    }

    public List<Usuario> buscarUsuariosPorEmail(){

        return null;
    }


    public void excluirContato(Usuario contato){
        List<Usuario> contatos = this.discenteSessao.getContatos();

        for (Usuario usu : contatos) {
            if(usu.getId() == contato.getId())
                contatos.remove(usu);

        }
        this.discenteLocal.atualizar(this.discenteSessao);

        //excluindo no sentido contrário

        contatos = contato.getContatos();

        for (Usuario usu : contatos) {
            if(usu.getId() == this.discenteSessao.getId())
                contatos.remove(usu);

        }
        this.usuarioLocal.atualizar(contato);



    }

    public void adicionarContato(Usuario contato){
        LOG.info("CONTATO: "+contato.getNome());
        if(this.discenteSessao.getContatos() == null){
            List<Usuario> novaLista = new ArrayList<Usuario>();
            novaLista.add(contato);
            this.discenteSessao.setContatos(novaLista);
            this.discenteLocal.atualizar(this.discenteSessao);

        }else{
            this.discenteSessao.getContatos().add(contato);
            this.discenteLocal.atualizar(this.discenteSessao);
        }

        // adicionando no sentido contrário
/*
        if(contato.getContatos() == null){
            List<Usuario> novaLista = new ArrayList<Usuario>();
            novaLista.add(this.discenteSessao);
            contato.setContatos(novaLista);
            this.usuarioLocal.atualizar(contato);

        }else{
            contato.getContatos().add(this.discenteSessao);
            this.usuarioLocal.atualizar(contato);
        }
*/


    }

    public Discente getDiscenteSessao() {
        return discenteSessao;
    }

    public void setDiscenteSessao(Discente discenteSessao) {
        this.discenteSessao = discenteSessao;
    }
}
