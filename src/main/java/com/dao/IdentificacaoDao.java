package com.dao;

import com.dominio.Identificacao;

import java.io.Serializable;

public class IdentificacaoDao extends GenericDao<Identificacao,Long> implements Serializable {

    public IdentificacaoDao() {
        super(Identificacao.class);
    }

}
