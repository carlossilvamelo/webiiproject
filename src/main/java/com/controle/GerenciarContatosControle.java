package com.controle;

import com.dominio.Usuario;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@RequestScoped
public class GerenciarContatosControle implements Serializable{


    public GerenciarContatosControle() {
    }

    public List<Usuario> listarContatosPor(Usuario usuario){

        return null;
    }

    public List<Usuario> listarTodosUsuarios(){

        return null;
    }

    public List<Usuario> filtarListaUsuariosPorLogin(){

        return null;
    }

    public List<Usuario> buscarUsuariosPorEmail(){

        return null;
    }


    public Usuario excluirContato(){

        return null;
    }

    public Usuario adicionarContato(){

        return null;
    }
}
