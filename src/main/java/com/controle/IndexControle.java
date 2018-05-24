package com.controle;


import com.IServicos.DiscenteLocal;
import com.IServicos.DocenteLocal;
import com.servicos.DiscenteServico;
import com.servicos.DocenteServico;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class IndexControle implements Serializable {

    private String cpf;
    private String senha;

    @EJB
    private DiscenteLocal discenteLocal;
    @EJB
    private DocenteLocal docenteLocal;

    public IndexControle() {
    }


    public void identificarUsuario(){
        System.out.println("CPF: "+this.cpf);
        System.out.println("Senha: "+this.senha);
    }

    public List<String> listarTrabalhos(){
        ArrayList<String> lista = new ArrayList<>();

        for (int i = 0 ; i<10 ; i++){

            lista.add("Trabalho "+i);
        }


        return lista;
    }


    public String logout(){
        System.out.println("LOGOUT");
        return "#{request.contextPath}/index?faces-redirect=true";
    }




    /* getters and setters */

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


}
