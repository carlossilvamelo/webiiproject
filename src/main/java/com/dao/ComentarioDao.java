package com.dao;

import com.dominio.Comentario;

public class ComentarioDao extends GenericDao<Comentario,Long>{

    public ComentarioDao() {
        super(Comentario.class);
    }
}
