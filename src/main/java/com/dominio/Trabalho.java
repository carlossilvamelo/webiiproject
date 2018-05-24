package com.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
public class Trabalho implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="resumo")
	private String resumo;
	
	@Column(name="curtidas")
	private Integer curtidas;
	
	@Enumerated(EnumType.STRING)
	@Column(name="status")
	private EnumStatusTrabalho status;
	
	@ManyToMany(mappedBy="trabalhos" ,cascade =CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Discente> discentes;

	@OneToMany(mappedBy = "trabalho", cascade = CascadeType.ALL)
	private List<Atividade> atividades;
	
	@OneToMany(mappedBy = "trabalho", cascade=CascadeType.ALL)
	private List<Comentario> comentarios;
	
	@ElementCollection
	private List<String> palavrasChave;

	@OneToMany(mappedBy = "trabalho", cascade=CascadeType.ALL)
	private List<Arquivo> arquivos;

    @OneToMany(mappedBy = "trabalho", cascade=CascadeType.ALL)
	private List<MensagemGrupo> mensagemGrupo;
	


	public Trabalho() {
		
	}
	
	public Trabalho( String titulo, String resumo, Integer curtidas, EnumStatusTrabalho status,
			ArrayList<Discente> participantes) {
		
		this.titulo = titulo;
		this.resumo = resumo;
		this.curtidas = curtidas;
		this.status = status;
		this.discentes = participantes;
	}

	public List<Discente> getDiscentes() {
		return discentes;
	}

	public void setDiscentes(List<Discente> discentes) {
		this.discentes = discentes;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getResumo() {
		return resumo;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	public Integer getCurtidas() {
		return curtidas;
	}
	public void setCurtidas(Integer curtidas) {
		this.curtidas = curtidas;
	}
	public EnumStatusTrabalho getStatus() {
		return status;
	}
	public void setStatus(EnumStatusTrabalho status) {
		this.status = status;
	}

	public List<String> getPalavrasChave() {
		return palavrasChave;
	}

	public void setPalavrasChave(List<String> palavrasChave) {
		this.palavrasChave = palavrasChave;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
