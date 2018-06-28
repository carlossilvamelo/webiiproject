package com.dominio;


import java.util.List;

import javax.persistence.*;


@Entity
@PrimaryKeyJoinColumn(name = "id_docente")
public class Docente extends Usuario{
	

	
	/**
	 * 
	 */


	
	@ElementCollection
	private List<String> areasPesquisa;
	
	
	
	//construtores

	
	public Docente() {
		// TODO Auto-generated constructor stub
	}
	
	
	//getters e setters
	public List<String> getAreasPesquisa() {
		return areasPesquisa;
	}
	public void setAreasPesquisa(List<String> areasPesquisa) {
		this.areasPesquisa = areasPesquisa;
	}
	
	
	
}
