package com.controle;

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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Named
@RequestScoped
public class ContatosDocenteControle implements Serializable {
    static final Logger LOG = Logger.getLogger(ContatosDocenteControle.class.getName());

    private Docente docenteSessao;

    @EJB
    private UsuarioLocal usuarioLocal;

    @EJB
    private DocenteLocal docenteLocal;

    public ContatosDocenteControle(){
        this.docenteSessao = (Docente) FacesContext.getCurrentInstance()
                .getExternalContext().getSessionMap().get("docente");
    }

    public List<Usuario> listarContatos(){

        return docenteSessao.getContatos();
    }

    public List<Usuario> listarTodosUsuarios(){
        List<Usuario> listaTodos = usuarioLocal.listarTodos();
        List<Usuario> nova = new ArrayList<Usuario>();
        if(this.docenteSessao.getContatos() != null) {

            for (Usuario usu : listaTodos) {

                Boolean exist = false;
                for (Usuario contato : this.docenteSessao.getContatos()) {
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
        List<Usuario> contatos = this.docenteSessao.getContatos();

        for (Usuario usu : contatos) {
            if(usu.getId() == contato.getId())
                contatos.remove(usu);

        }


        this.docenteLocal.atualizar(this.docenteSessao);
    }

    public void adicionarContato(Usuario contato){
        LOG.info("CONTATO: "+contato.getNome());
        if(this.docenteSessao.getContatos() == null){
            List<Usuario> novaLista = new ArrayList<Usuario>();
            novaLista.add(contato);
            this.docenteSessao.setContatos(novaLista);
            this.docenteLocal.atualizar(this.docenteSessao);

        }else{
            this.docenteSessao.getContatos().add(contato);
            this.docenteLocal.atualizar(this.docenteSessao);
        }

    }

    public Docente getDocenteSessao() {
        return docenteSessao;
    }

    public void setDocenteSessao(Docente docenteSessao) {
        this.docenteSessao = docenteSessao;
    }
}
