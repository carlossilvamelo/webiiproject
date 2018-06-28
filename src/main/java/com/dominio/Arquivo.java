package com.dominio;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Arquivo implements Serializable{

	@Id
	private Long id;
	private String link;
	private String descricao;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="trabalho")
	private Trabalho trabalho;


	public Arquivo() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Trabalho getTrabalho() {
		return trabalho;
	}

	public void setTrabalho(Trabalho trabalho) {
		this.trabalho = trabalho;
	}
}
