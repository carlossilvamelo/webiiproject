package com.dao;


import com.dominio.Endereco;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 *
 */
public class EnderecoDao extends GenericDao<Endereco, Long>{

    public EnderecoDao(){
        super(Endereco.class);
    }


}
