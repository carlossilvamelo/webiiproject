package com.servicos;

import com.IServicos.DocenteLocal;
import com.dominio.Docente;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class DocenteServico implements DocenteLocal{
    static final Logger LOG = Logger.getLogger(DocenteServico.class.getName());

    @EJB
    private FachadaDaoServico fachadaDaoServico;

    @Override
    public Docente inserir(Docente entidade) {
        LOG.info("Inserir Docente");
        fachadaDaoServico.getDocenteDao().inserir(entidade);
        return entidade;
    }

    @Override
    public Docente atualizar(Docente entidade) {
        fachadaDaoServico.getDocenteDao().atualizar(entidade);
        return entidade;
    }

    @Override
    public Docente remover(Docente entidade) {
        return null;
    }

    @Override
    public Docente buscar(Docente entidade) {
        return null;
    }

    @Override
    public Docente buscarPorId(Long id) {
        return fachadaDaoServico.getDocenteDao().buscarPorId(id);

    }

    @Override
    public List<Docente> listarTodos() {
        return null;
    }
}
