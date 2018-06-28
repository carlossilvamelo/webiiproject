package com.dao;


import com.dominio.Endereco;

import javax.ejb.Stateless;

/**
 *
 */
@Stateless
public class EnderecoDao extends GenericDao<Endereco, Long>{

    public EnderecoDao(){
        super(Endereco.class);
    }


}
