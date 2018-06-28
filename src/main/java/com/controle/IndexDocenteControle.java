package com.controle;

import com.IServicos.DocenteLocal;
import com.IServicos.TrabalhoLocal;
import com.dominio.Discente;
import com.dominio.Docente;
import com.dominio.Trabalho;
import com.dominio.Usuario;
import com.servicos.DocenteServico;
import com.servicos.TrabalhoServico;
import org.primefaces.context.PrimeFacesContext;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;


@Named
@RequestScoped
public class IndexDocenteControle implements Serializable {
    static final Logger LOG = Logger.getLogger(IndexDocenteControle.class.getName());

    private Docente docenteSessao;
    @EJB
    private DocenteLocal docenteLocal;
    @EJB
    private TrabalhoLocal trabalhoLocal;

    private Trabalho trabalhoVisualizado;



    public IndexDocenteControle(){
        this.docenteSessao = (Docente) FacesContext.getCurrentInstance()
                .getExternalContext().getSessionMap().get("docente");
    }



    /**
     * Buscar a lista de trabalhos que o discente participa
     *
     * @return trabalhos -  lista de trabalhos do discente
     */
    public List<Trabalho> carregarTimeLine(){

        return this.trabalhoLocal.listarTodos();
    }

    /**
     * Buscar a lista dos contatos do discente
     *
     * @return contatos - lista de contatos
     */
    public List<Usuario> listarContatos(){

        return docenteSessao.getContatos();
    }

    public String logout(){
        FacesContext.getCurrentInstance().getExternalContext()
                .getSessionMap().put("docente", null);
        return "../index?faces-redirect=true";
    }

    public void selecionarTrabalho(Trabalho trabalho){
        LOG.info("titulo trabalho selecionado");
        LOG.info(trabalho.getTitulo());
        this.trabalhoVisualizado = trabalho;

    }


    public Docente getDocenteSessao() {
        return docenteSessao;
    }

    public void setDocenteSessao(Docente docenteSessao) {
        this.docenteSessao = docenteSessao;
    }

    public Trabalho getTrabalhoVisualizado() {
        return trabalhoVisualizado;
    }

    public void setTrabalhoVisualizado(Trabalho trabalhoVisualizado) {
        this.trabalhoVisualizado = trabalhoVisualizado;
    }
}
