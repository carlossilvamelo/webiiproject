package com.dao;

import com.dominio.Mensagem;

public class MensagemDao extends GenericDao<Mensagem,Long> {

    public MensagemDao() {
        super(Mensagem.class);
    }
}
