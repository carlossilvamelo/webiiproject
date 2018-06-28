package com.dao;

import com.dominio.Comentario;

import javax.ejb.Stateless;

@Stateless
public class ComentarioDao extends GenericDao<Comentario,Long>{

    public ComentarioDao() {
        super(Comentario.class);
    }
}
