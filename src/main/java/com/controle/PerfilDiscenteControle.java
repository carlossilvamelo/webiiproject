package com.controle;

import com.IServicos.DiscenteLocal;
import com.dominio.Discente;


import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.logging.Logger;

@Named
@RequestScoped
public class PerfilDiscenteControle implements Serializable {
    static final Logger LOG = Logger.getLogger(PerfilDiscenteControle.class.getName());



    private Discente discenteSessao;
    @EJB
    private DiscenteLocal discenteLocal;



    public PerfilDiscenteControle(){

        this.discenteSessao = (Discente)FacesContext.getCurrentInstance()
                .getExternalContext().getSessionMap().get("discente");


    }

    public void atualizar(){

        LOG.info("CEP"+this.discenteSessao.getEndereco().getCep());
        discenteLocal.atualizar(discenteSessao);
    }





    public Discente getDiscenteSessao() {
        return discenteSessao;
    }

    public void setDiscenteSessao(Discente discenteSessao) {
        this.discenteSessao = discenteSessao;
    }


}
