package com.dao;

import com.dominio.Mensagem;

import javax.ejb.Stateless;

@Stateless
public class MensagemDao extends GenericDao<Mensagem,Long> {

    public MensagemDao() {
        super(Mensagem.class);
    }
}
