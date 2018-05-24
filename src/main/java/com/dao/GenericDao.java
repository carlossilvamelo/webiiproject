package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

public abstract class GenericDao<T, I extends Serializable> {


   // @PersistenceContext(unitName = "webiiproject")
    protected EntityManager entityManager=
           Persistence.createEntityManagerFactory("webiiproject").createEntityManager();

    private Class<T> entidadePersistida;

    protected GenericDao(Class<T> entidadePersistida){
        this.entidadePersistida = entidadePersistida;
    }

    public T inserir(T entidade){
        getEntityManager().getTransaction().begin();
        getEntityManager().persist(entidade);
        getEntityManager().getTransaction().commit();
        return entidade;
    }

    public T atualizar(T entidade){

        getEntityManager().getTransaction().begin();
        getEntityManager().merge(entidade);
        getEntityManager().getTransaction().commit();
        return entidade;
    }

    public T remover(T entidade){
        T current = null;
        getEntityManager().getTransaction().begin();
        if (!getEntityManager().contains(entidade)) {
            current = getEntityManager().merge(entidade);
            getEntityManager().remove(current);
            getEntityManager().getTransaction().commit();
        }else {
            getEntityManager().remove(entidade);
            getEntityManager().getTransaction().commit();
        }
        return entidade;
    }

    public T buscar(T entidade){
        return entidade;
    }

    public T buscarPorId(I id) {
        return entityManager.find(entidadePersistida, id);
    }

    public List<T> listarTodos(){
        getEntityManager().getTransaction().begin();
        TypedQuery<T> query = getEntityManager().createQuery("SELECT t FROM "+entidadePersistida.getName()+" t", entidadePersistida);
        getEntityManager().getTransaction().commit();
        return query.getResultList();
    }

    /* Getters and setters*/

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
