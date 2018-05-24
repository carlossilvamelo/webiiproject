package com.dominio;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Comentario {

	@Id
	@Column(name="id")
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="usuario")
	private Usuario usuario;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="trabalho")
	private Trabalho trabalho;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data")
	private Date data;
	
	
	@Column(name="texto")
	private String texto;
	
	
	
	
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
}
