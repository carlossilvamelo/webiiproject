package com.dominio;

import javax.enterprise.inject.Produces;

public class DominioFabrica {



    public DominioFabrica() {
    }



    @Produces
    public static Usuario usuario(){
        return new Usuario();
    }

    @Produces
    public static Trabalho trabalho(){
        return new Trabalho();
    }

    @Produces
    public static Discente discente(){
        return new Discente();
    }
    @Produces
    public static Docente docente(){
        return new Docente();
    }

    @Produces
    public static Endereco endereco(){
        return new Endereco();
    }

    @Produces
    public static Identificacao identificacao(){
        return new Identificacao();
    }




}
