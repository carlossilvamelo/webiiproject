package com.dao;

import com.dominio.Usuario;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class UsuarioDao extends GenericDao<Usuario,Long> {


    public UsuarioDao() {
        super(Usuario.class);
    }

    public Usuario buscarPorCpf(String cpf) throws NoResultException {

        String stringQuery = "SELECT u FROM Usuario u WHERE u.cpf = ?1";

        getEntityManager().getTransaction().begin();

        TypedQuery<Usuario> query = (TypedQuery<Usuario>) getEntityManager()
                .createQuery(stringQuery);

        query.setParameter(1, cpf);
        getEntityManager().getTransaction().commit();
        Usuario usuario = null;
        try {
            usuario = query.getSingleResult();
        }catch (NoResultException e){
            return null;
        }
      //  LOG.info("result size "+usuario.getCpf()+usuario.getNome());

    return usuario;
    }

}
