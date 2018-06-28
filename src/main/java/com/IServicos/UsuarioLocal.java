package com.IServicos;

import com.dominio.Usuario;

import javax.ejb.Local;

@Local
public interface UsuarioLocal extends CrudGenerico<Usuario, String>{

    public Usuario buscarPorCpf(String cpf);
}
