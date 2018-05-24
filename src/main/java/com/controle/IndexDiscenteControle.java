package com.controle;

import com.dominio.Trabalho;
import com.dominio.Usuario;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 */
@Named
@RequestScoped
public class IndexDiscenteControle implements Serializable{


    public IndexDiscenteControle() {
    }

    /**
     * Buscar a lista de trabalhos que o discente participa
     *
     * @return trabalhos -  lista de trabalhos do discente
     */
    public List<Trabalho> listarTrabalhos(){
        ArrayList<Trabalho> trabalhos = new ArrayList<>();
        Trabalho trabalho;

        for (int i = 0 ; i<4 ; i++){
            trabalho = new Trabalho();
            trabalho.setId(new Long(1L));
            trabalho.setCurtidas(i);
            trabalho.setTitulo("Trabalho "+i);
            trabalho.setResumo("Resumo do trabalho "+i);
            trabalhos.add(trabalho);
        }

        System.out.println("tamanho: "+trabalhos.size());
        return trabalhos;
    }


    /**
     * Buscar a lista dos contatos do discente
     *
     * @return contatos - lista de contatos
     */
    public List<Usuario> listarContatos(){
        ArrayList<Usuario> contatos = new ArrayList<>();
        Usuario usuario;

        for (int i = 0 ; i<4 ; i++){
            usuario = new Usuario();
            usuario.setNome("Contato "+i);
            contatos.add(usuario);
        }

        return contatos;
    }


}
