package com.dominio;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

@Entity
public class MensagemGrupo implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="id_remetente")
	private Long idRemetente;


	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="trabalho")
	private Trabalho trabalho;


	@Column(name="data_hora")
	private Date dataHora;
	
	@Column(name="conteudo")
	private String conteudo;

	public MensagemGrupo() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdRemetente() {
		return idRemetente;
	}

	public void setIdRemetente(Long idRemetente) {
		this.idRemetente = idRemetente;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
}
