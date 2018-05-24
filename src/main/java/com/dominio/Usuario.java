package com.dominio;

import java.util.Date;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.enterprise.inject.Default;
import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="sobrenome")
	private String sobreNome;
	
	@Column(name="tipo")
	private String tipo;
	
	@Column(name="cpf")
	private String cpf;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;
	
	@Column(name="email")
	private String email = "";
	
	@Column(name="curriculo")
	private String curriculo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_nascimento")
	private Date dataNascimento;

    @OneToOne(cascade = CascadeType.ALL)
	private Identificacao identidicacao;
	
	@ElementCollection
	private List<String> areasConhecimentos;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Usuario> contatos;


    @OneToMany(cascade = CascadeType.ALL)
    List<Comentario> comentarios;


    //contrutores
	

	public Usuario() {
		// TODO Auto-generated constructor stub
	}



	//esse metodo vai para o clienteService
	public Integer calcularIdadePorDataNascimento(Calendar dataNascimento){
		return null;
	}

    public List<Usuario> getContatos() {
        return contatos;
    }

    public void setContatos(List<Usuario> contatos) {
        this.contatos = contatos;
    }

    public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(String curriculo) {
		this.curriculo = curriculo;
	}



	public Identificacao getIdentidicacao() {
		return identidicacao;
	}

	public void setIdentidicacao(Identificacao identidicacao) {
		this.identidicacao = identidicacao;
	}

	public List<String> getAreasConhecimentos() {
		return areasConhecimentos;
	}

	public void setAreasConhecimentos(List<String> areasConhecimentos) {
		this.areasConhecimentos = areasConhecimentos;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}









	public String getSobreNome() {
		return sobreNome;
	}



	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}



	public Date getDataNascimento() {
		return dataNascimento;
	}



	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	
	
}
