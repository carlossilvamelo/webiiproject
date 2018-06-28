package com.controle;

import com.dominio.Discente;
import com.dominio.Trabalho;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

@Named
@RequestScoped
public class TrabalhosDiscenteControle implements Serializable {
    static final Logger LOG = Logger.getLogger(TrabalhosDiscenteControle.class.getName());

    private Discente discenteSessao;


    public TrabalhosDiscenteControle(){
        this.discenteSessao = (Discente) FacesContext.getCurrentInstance()
                .getExternalContext().getSessionMap().get("discente");

    }

    public List<Trabalho> listarTrabalhos(){
        return this.discenteSessao.getTrabalhos();
    }

    public String gerenciarTrabalho(Trabalho trabalho){

        LOG.info(trabalho.getTitulo());
     //  String idTrabalhoSelecionado =  FacesContext.getCurrentInstance().getExternalContext()
     //           .getRequestParameterMap().put("idTrabalho",trabalho.getId()+"");
        TrabalhoControle.idTrabalhoSelecionado = trabalho.getId();
        return "trabalho?faces-redirect=true";
    }




    public Discente getDiscenteSessao() {
        return discenteSessao;
    }

    public void setDiscenteSessao(Discente discenteSessao) {
        this.discenteSessao = discenteSessao;
    }
}
