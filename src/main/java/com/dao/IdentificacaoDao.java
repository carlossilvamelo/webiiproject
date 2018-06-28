package com.dao;

import com.dominio.Identificacao;

import javax.ejb.Stateless;
import java.io.Serializable;

@Stateless
public class IdentificacaoDao extends GenericDao<Identificacao,Long> implements Serializable {

    public IdentificacaoDao() {
        super(Identificacao.class);
    }

}
