package com.dao;

import com.dominio.Atividade;

import javax.ejb.Stateless;

@Stateless
public class AtividadeDao extends GenericDao<Atividade,Long> {

    public AtividadeDao() {
        super(Atividade.class);
    }
}
