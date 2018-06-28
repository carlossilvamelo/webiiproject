package com.dao;

import com.dominio.Arquivo;

import javax.ejb.Stateless;

@Stateless
public class ArquivoDao extends GenericDao<Arquivo,Long> {

    public ArquivoDao() {
        super(Arquivo.class);
    }
}
