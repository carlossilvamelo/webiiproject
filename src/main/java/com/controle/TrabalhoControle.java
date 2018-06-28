package com.controle;

import com.IServicos.DiscenteLocal;
import com.dominio.Discente;
import com.dominio.DominioFabrica;
import com.dominio.Trabalho;
import com.servicos.DiscenteServico;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Named
@RequestScoped
public class TrabalhoControle implements Serializable {
    static final Logger LOG = Logger.getLogger(TrabalhoControle.class.getName());

    public static Long idTrabalhoSelecionado;
    private Discente discenteSessao;
    private Trabalho novoTrabalho;


    private Trabalho trabalho;
    private int idSelecionado;

    @EJB
    private DiscenteLocal discenteLocal;


    public TrabalhoControle(){
       this.discenteSessao = (Discente) FacesContext.getCurrentInstance().getExternalContext()
                .getSessionMap().get("discente");
        novoTrabalho = DominioFabrica.trabalho();
        if(idTrabalhoSelecionado != null) {
             this.idSelecionado = buscarIndiceTrabalho(idTrabalhoSelecionado);
             this.trabalho = getTrabalhoSelecionado();

        }
        LOG.info("idSelecionado: "+idTrabalhoSelecionado);

    }


    public Trabalho getTrabalhoSelecionado(){

        return this.discenteSessao.getTrabalhos().get(this.idSelecionado);
    }

    public String cadastrarTrabalho(){
        //implementar serviço trabalho

        List<Trabalho> trabalhos = this.discenteSessao.getTrabalhos();
        if(trabalhos == null){

            List<Trabalho> novaListaTrabalhos = new ArrayList<Trabalho>();
            novaListaTrabalhos.add(novoTrabalho);

            this.discenteSessao.setTrabalhos(novaListaTrabalhos);
            this.discenteLocal.atualizar(discenteSessao);

        }else{

            trabalhos.add(novoTrabalho);
            this.discenteSessao.setTrabalhos(trabalhos);
            this.discenteLocal.atualizar(discenteSessao);

        }

        LOG.info(novoTrabalho.getTitulo());
        LOG.info(novoTrabalho.getResumo());


        return "trabalhos-alunos?faces-redirect=true";
    }

    private int buscarIndiceTrabalho(Long idTrabalhoSelecionado){
        Long id = idTrabalhoSelecionado;

        int index =0;
        for (Trabalho trabalho : this.discenteSessao.getTrabalhos()) {
            if(trabalho.getId() == id){

                break;
            }
            index++;
        }

        return index;
    }

    public Trabalho getNovoTrabalho() {
        return novoTrabalho;
    }

    public Trabalho getTrabalho() {
        return trabalho;
    }

    public void setTrabalho(Trabalho trabalho) {
        this.trabalho = trabalho;
    }

    public void setNovoTrabalho(Trabalho novoTrabalho) {
        this.novoTrabalho = novoTrabalho;
    }


}
