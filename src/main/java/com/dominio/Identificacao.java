package com.dominio;

import javax.persistence.*;

@Entity
public class Identificacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="login")
	private String login;
	
	@Column(name="senha")
	private String senha;

	public Identificacao(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}

	public Identificacao() {
		// TODO Auto-generated constructor stub
	}

	// getters and setters
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
