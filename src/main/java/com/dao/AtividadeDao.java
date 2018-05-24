package com.dao;

import com.dominio.Atividade;

public class AtividadeDao extends GenericDao<Atividade,Long> {

    public AtividadeDao() {
        super(Atividade.class);
    }
}
