package com.dao;

import com.dominio.Discente;

import javax.ejb.Stateless;
import java.io.Serializable;

@Stateless
public class DiscenteDao extends GenericDao<Discente,Long> implements Serializable{

    public DiscenteDao() {
        super(Discente.class);
    }
}
