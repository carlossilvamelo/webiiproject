package com.dao;

import com.dominio.Docente;

import javax.ejb.Stateless;

@Stateless
public class DocenteDao extends GenericDao<Docente,Long>{



    public DocenteDao() {
        super(Docente.class);
    }
}
