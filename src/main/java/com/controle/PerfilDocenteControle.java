package com.controle;

import com.IServicos.DocenteLocal;
import com.dominio.Docente;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.logging.Logger;

@Named
@RequestScoped
public class PerfilDocenteControle implements Serializable {
    static final Logger LOG = Logger.getLogger(PerfilDocenteControle.class.getName());


    private Docente docente;
    @EJB
    private DocenteLocal docenteLocal;


    public PerfilDocenteControle(){

        this.docente = (Docente)FacesContext.getCurrentInstance()
                .getExternalContext().getSessionMap().get("docente");

    }

    public void atualizar(){

        LOG.info("CEP"+this.docente.getEndereco().getCep());
        docenteLocal.atualizar(docente);
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }
}
