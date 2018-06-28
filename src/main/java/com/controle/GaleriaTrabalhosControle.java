package com.controle;

import com.IServicos.TrabalhoLocal;
import com.dominio.Docente;
import com.dominio.Trabalho;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

@Named
@RequestScoped
public class GaleriaTrabalhosControle implements Serializable {
    static final Logger LOG = Logger.getLogger(GaleriaTrabalhosControle.class.getName());
    private Docente docenteSessao;
    @EJB
    private TrabalhoLocal trabalhoLocal;

    public GaleriaTrabalhosControle(){
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

    public Docente getDocenteSessao() {
        return docenteSessao;
    }

    public void setDocenteSessao(Docente docenteSessao) {
        this.docenteSessao = docenteSessao;
    }
}
