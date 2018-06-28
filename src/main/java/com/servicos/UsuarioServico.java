package com.servicos;

import com.IServicos.UsuarioLocal;
import com.dominio.Usuario;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class UsuarioServico implements UsuarioLocal {


    public List<Usuario> buscarContatosPor(Usuario usuario){

        return null;
    }

    @EJB
    private FachadaDaoServico fachadaDaoServico;

    @Override
    public Usuario buscarPorCpf(String cpf){
       Usuario usuario = fachadaDaoServico.getUsuarioDao().buscarPorCpf(cpf);

       return usuario;
    }

    @Override
    public Usuario inserir(Usuario entidade) {

        return null;
    }

    @Override
    public Usuario atualizar(Usuario entidade) {
        return null;
    }

    @Override
    public Usuario remover(Usuario entidade) {
        return null;
    }

    @Override
    public Usuario buscar(Usuario entidade) {
        return null;
    }

    @Override
    public Usuario buscarPorId(String id) {
        return null;
    }

    @Override
    public List<Usuario> listarTodos() {
        return fachadaDaoServico.getUsuarioDao().listarTodos();
    }
}
