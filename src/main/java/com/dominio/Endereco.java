package com.dominio;

import javax.persistence.*;

@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@Column(name="rua")
	private String rua;
	
	@Column(name="numero")
	private Integer numero;
	
	@Column(name="cep")
	private String cep;
	
	@Column(name="estado")
	private String estado;
	

	
	
	public Endereco() {
		
		
		this.rua = "";
		this.numero = 0;
		this.cep = "";
		this.estado = "";
	}


	
	
	
	//getters and setters

	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}


}
