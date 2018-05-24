package com.dao;

import com.dominio.Usuario;

public class UsuarioDao extends GenericDao<Usuario,Long> {

    public UsuarioDao() {
        super(Usuario.class);
    }

}
