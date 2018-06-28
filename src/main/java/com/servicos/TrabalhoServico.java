package com.servicos;

import com.IServicos.TrabalhoLocal;
import com.dao.TrabalhoDao;
import com.dominio.Trabalho;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class TrabalhoServico implements TrabalhoLocal {


    @EJB
    private FachadaDaoServico fachadaDaoServico;


    @Override
    public Trabalho inserir(Trabalho entidade) {
        return null;
    }

    @Override
    public Trabalho atualizar(Trabalho entidade) {
        return null;
    }

    @Override
    public Trabalho remover(Trabalho entidade) {
        return null;
    }

    @Override
    public Trabalho buscar(Trabalho entidade) {
        return null;
    }

    @Override
    public Trabalho buscarPorId(Long id) {
        return null;
    }

    @Override
    public List<Trabalho> listarTodos() {

        return fachadaDaoServico.getTrabalhoDao().listarTodos();
    }
}
