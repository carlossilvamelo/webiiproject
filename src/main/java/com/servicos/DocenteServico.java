package com.servicos;

import com.IServicos.DocenteLocal;
import com.dominio.Docente;

import javax.ejb.Stateless;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class DocenteServico implements DocenteLocal{
    static final Logger LOG = Logger.getLogger(DocenteServico.class.getName());
    @Override
    public Docente inserir(Docente entidade) {
        return null;
    }

    @Override
    public Docente atualizar(Docente entidade) {
        return null;
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
        return null;
    }

    @Override
    public List<Docente> listarTodos() {
        return null;
    }
}
