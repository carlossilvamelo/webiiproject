package com.dao;

import com.dominio.Trabalho;

import javax.ejb.Stateless;


@Stateless
public class TrabalhoDao extends GenericDao<Trabalho,Long> {
    public TrabalhoDao() {
        super(Trabalho.class);
    }
}
