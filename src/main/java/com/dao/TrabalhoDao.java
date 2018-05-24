package com.dao;

import com.dominio.Trabalho;

public class TrabalhoDao extends GenericDao<Trabalho,Long> {
    public TrabalhoDao() {
        super(Trabalho.class);
    }
}
