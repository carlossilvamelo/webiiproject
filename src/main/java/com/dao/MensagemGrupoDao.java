package com.dao;

import com.dominio.MensagemGrupo;

import javax.ejb.Stateless;

@Stateless
public class MensagemGrupoDao extends GenericDao<MensagemGrupo,Long>{

    public MensagemGrupoDao() {
        super(MensagemGrupo.class);
    }
}
