package com.dao;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProdutorEntityManager {

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("webiiproject");

    @Produces
    @RequestScoped
    public static EntityManager criaEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public void finaliza(@Disposes EntityManager manager) {
        manager.close();
    }

}
