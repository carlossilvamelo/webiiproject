package com.IServicos;

import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

public interface CrudGenerico<T, I extends Serializable> {

    public T inserir(T entidade);

    public T atualizar(T entidade);

    public T remover(T entidade);

    public T buscar(T entidade);

    public T buscarPorId(I id);

    public List<T> listarTodos();
}
