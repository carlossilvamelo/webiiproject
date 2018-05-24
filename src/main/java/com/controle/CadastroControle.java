package com.controle;


import com.IServicos.DiscenteLocal;
import com.IServicos.DocenteLocal;
import com.dominio.Discente;
import com.dominio.Docente;
import com.dominio.Identificacao;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Named
@RequestScoped
public class CadastroControle implements Serializable{



    private String nome;
    private String sobreNome;
    private String cpf;
    private String senha;
    private String tipo;


    @EJB
    private DiscenteLocal discenteLocal;
    @EJB
    private DocenteLocal docenteLocal;


    public CadastroControle() {
    }

    public String cadastrarUsuario(){


        Identificacao identificacao = new Identificacao();
        identificacao.setLogin(getNome());
        identificacao.setSenha(getSenha());

        if(getTipo().equals("Discente")){

            Discente discente = new Discente();
            discente.setNome(getNome());
            discente.setSobreNome(getSobreNome());
            discente.setCpf(getCpf());
            discente.setIdentidicacao(identificacao);

            discenteLocal.inserir(discente);
        }else{
            Docente docente = new Docente();
            docente.setNome(getNome());
            docente.setSobreNome(getSobreNome());
            docente.setIdentidicacao(identificacao);

            docenteLocal.inserir(docente);
        }


        return "index?faces-redirect=true";
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


}
