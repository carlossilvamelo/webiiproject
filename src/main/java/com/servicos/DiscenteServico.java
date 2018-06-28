package com.servicos;

import com.IServicos.DiscenteLocal;
import com.dominio.Discente;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class DiscenteServico implements DiscenteLocal{
    static final Logger LOG = Logger.getLogger(DiscenteServico.class.getName());


    @EJB
    private FachadaDaoServico fachadaDaoServico;



    @Override
    public Discente inserir(Discente entidade) {
       LOG.info(entidade.getNome());
       LOG.info(entidade.getCpf());
        LOG.info("SERVIÇO     public Discente inserir(Discente entidade)");
        fachadaDaoServico.getDiscenteDao().inserir(entidade);
        return entidade;
    }

    @Override
    public Discente atualizar(Discente entidade) {
        fachadaDaoServico.getDiscenteDao().atualizar(entidade);
        return entidade;
    }

    @Override
    public Discente remover(Discente entidade) {
        fachadaDaoServico.getDiscenteDao().remover(entidade);
        return entidade;
    }

    @Override
    public Discente buscar(Discente entidade) {
        fachadaDaoServico.getDiscenteDao().buscar(entidade);
        return entidade;
    }

    @Override
    public Discente buscarPorId(Long id) {
        Discente discente = fachadaDaoServico.getDiscenteDao().buscarPorId(id);
        return discente;
    }

    @Override
    public List<Discente> listarTodos() {
        return null;
    }
}
