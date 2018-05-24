package com.dominio;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Atividade {
    @Id
    @Column(name="id")
    private Long id;

    //@Column(name="participantes")
    //private List<Discente> participantes;

    @Enumerated(EnumType.STRING)
    @Column(name="Status")
    private EnumStatusAtvidade Status;

    @Column(name="descricao")
    private String descricao;

    @Column(name="data_entrega")
    private Date dataEntrega;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="trabalho")
    private Trabalho trabalho;




    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    /*	public List<Discente> getParticipantes() {
            return participantes;
        }
        public void setParticipantes(List<Discente> participantes) {
            this.participantes = participantes;
        }*/
    public EnumStatusAtvidade getStatus() {
        return Status;
    }
    public void setStatus(EnumStatusAtvidade status) {
        Status = status;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Date getDataEntrega() {
        return dataEntrega;
    }
    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public Trabalho getTrabalho() {
        return trabalho;
    }

    public void setTrabalho(Trabalho trabalho) {
        this.trabalho = trabalho;
    }
}
