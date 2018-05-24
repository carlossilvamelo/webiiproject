package com.dominio;



import java.util.List;

import javax.persistence.*;


@Entity
@PrimaryKeyJoinColumn(name = "id_discente")
public class Discente extends Usuario{

	
	private static final long serialVersionUID = 1L;

	@Column(name="matricula")
	private String matricula;
	@Column(name="reputacao")
	private String reputacao;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name="discente_trabalho",
            joinColumns={@JoinColumn(name="discente_id")},
			inverseJoinColumns={@JoinColumn(name="trabalho_id")})
	private List<Trabalho> trabalhos;




	//construtores
	
	
	
	
	
	
	
	public Discente() {
		// TODO Auto-generated constructor stub
	}


	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public String getReputacao() {
		return reputacao;
	}


	public void setReputacao(String reputacao) {
		this.reputacao = reputacao;
	}


	public List<Trabalho> getTrabalhos() {
		return trabalhos;
	}


	public void setTrabalhos(List<Trabalho> trabalhos) {
		this.trabalhos = trabalhos;
	}
	


	
	
}
