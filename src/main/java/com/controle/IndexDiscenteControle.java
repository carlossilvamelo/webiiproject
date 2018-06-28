package com.controle;

import com.IServicos.TrabalhoLocal;
import com.dominio.Discente;
import com.dominio.Trabalho;
import com.dominio.Usuario;
import com.servicos.TrabalhoServico;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 *
 */
@Named
@RequestScoped
public class IndexDiscenteControle implements Serializable{
    static final Logger LOG = Logger.getLogger(IndexDiscenteControle.class.getName());

    private Discente discenteSessao;

    @EJB
    private TrabalhoLocal trabalhoLocal;
    private Trabalho trabalhoVisualizado;

    public IndexDiscenteControle() {
        this.discenteSessao = (Discente) FacesContext.getCurrentInstance()
                .getExternalContext().getSessionMap().get("discente");

        LOG.info("Sessao: "+discenteSessao.getNome());

    }

    /**
     * Buscar a lista de trabalhos que o discente participa
     *
     * @return trabalhos -  lista de trabalhos do discente
     */
    public List<Trabalho> carregarTimeLine(){

        return this.trabalhoLocal.listarTodos();
    }
    public void selecionarTrabalho(Trabalho trabalho){

        this.trabalhoVisualizado = trabalho;

    }


    public void logout(){
        FacesContext.getCurrentInstance().getExternalContext()
                .getSessionMap().put("discente", null);

    }


    /**
     * Buscar a lista dos contatos do discente
     *
     * @return contatos - lista de contatos
     */
    public List<Usuario> listarContatos(){

        return discenteSessao.getContatos();
    }

    public Discente getDiscenteSessao() {
        return discenteSessao;
    }

    public void setDiscenteSessao(Discente discenteSessao) {
        this.discenteSessao = discenteSessao;
    }

    public Trabalho getTrabalhoVisualizado() {
        return trabalhoVisualizado;
    }

    public void setTrabalhoVisualizado(Trabalho trabalhoVisualizado) {
        this.trabalhoVisualizado = trabalhoVisualizado;
    }
}
