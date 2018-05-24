package com.dao;

import com.dominio.Arquivo;

public class ArquivoDao extends GenericDao<Arquivo,Long> {

    public ArquivoDao() {
        super(Arquivo.class);
    }
}
