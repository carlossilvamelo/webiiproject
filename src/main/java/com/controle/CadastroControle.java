package com.controle;


import com.IServicos.DiscenteLocal;
import com.IServicos.DocenteLocal;
import com.dominio.*;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.logging.Logger;

@Named
@RequestScoped
public class CadastroControle implements Serializable{
    static final Logger LOG = Logger.getLogger(CadastroControle.class.getName());


    private String nome;
    private String sobreNome;
    private String cpf;
    private String senha;
    private String tipo;
    private Boolean erro = false;



    @EJB
    private DiscenteLocal discenteLocal;
    @EJB
    private DocenteLocal docenteLocal;

     @PersistenceContext(unitName = "webiiproject")
     private EntityManager entityManager;

    public CadastroControle() {
    }

    public String cadastrarUsuario(){

        if((getNome().equals(""))||
                (getSobreNome().equals(""))||
                (getCpf().equals(""))||
                (getSenha().equals(""))||
                (getTipo() == null)){
            this.setErro(true);
            return "cadastro";
        }

        Identificacao identificacao = DominioFabrica.identificacao();
        identificacao.setLogin(getNome());
        identificacao.setSenha(getSenha());
        Endereco endereco = new Endereco();
        endereco.setCep("");
        endereco.setEstado("");
        endereco.setNumero(0);
        endereco.setRua("");

        if(getTipo().equals("Discente")){

            Discente discente = DominioFabrica.discente();
            discente.setNome(getNome());
            discente.setEmail("");

            discente.setReputacao("");
            discente.setEndereco(endereco);
            discente.setSobreNome(getSobreNome());
            discente.setCpf(getCpf());
            discente.setTipo(tipo);
            discente.setIdentificacao(identificacao);
            LOG.info("Discente");
            discenteLocal.inserir(discente);

        }else{


            Docente docente = DominioFabrica.docente();
            docente.setNome(getNome());
            docente.setCpf(getCpf());
            docente.setSobreNome(getSobreNome());
            docente.setIdentificacao(identificacao);
            docente.setTipo(tipo);
            docente.setEmail("");
            docente.setEndereco(endereco);

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

    public Boolean getErro() {
        return erro;
    }

    public void setErro(Boolean erro) {
        this.erro = erro;
    }
}
