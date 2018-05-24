package com.servicos;

import com.IServicos.DiscenteLocal;
import com.dao.DaoFacade;
import com.dominio.Discente;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class DiscenteServico implements DiscenteLocal{
    static final Logger LOG = Logger.getLogger(DiscenteServico.class.getName());


    @EJB
    private DaoFacade daoFacade;



    @Override
    public Discente inserir(Discente entidade) {
       LOG.info(entidade.getNome());
       LOG.info(entidade.getCpf());

        // daoFacade.getDiscenteDao().inserir(entidade);
        return entidade;
    }

    @Override
    public Discente atualizar(Discente entidade) {
        daoFacade.getDiscenteDao().atualizar(entidade);
        return entidade;
    }

    @Override
    public Discente remover(Discente entidade) {
        daoFacade.getDiscenteDao().remover(entidade);
        return entidade;
    }

    @Override
    public Discente buscar(Discente entidade) {
        daoFacade.getDiscenteDao().buscar(entidade);
        return entidade;
    }

    @Override
    public Discente buscarPorId(Long id) {
        Discente discente = null;
        return discente;
    }

    @Override
    public List<Discente> listarTodos() {
        return null;
    }
}
