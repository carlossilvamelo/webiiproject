package com.utils;

import com.dao.DiscenteDao;
import com.dominio.Discente;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.Assert.assertNotNull;

public class Testes {
    private static final Logger LOG = Logger.getLogger(Testes.class.getName());


    private static DiscenteDao discenteDao = new DiscenteDao();

    public static void main(String[] args){
        List<Discente> lista = discenteDao.listarTodos();
        LOG.info("Size: "+ lista.size());
        for (Discente d: lista) {
            LOG.info("Nome: "+d.getNome());
        }


    }
}
