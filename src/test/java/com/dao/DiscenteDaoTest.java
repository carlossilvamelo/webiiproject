package com.dao;

import com.dominio.*;
import org.junit.Test;

import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

public class DiscenteDaoTest implements ICrudTest{
    private static final Logger LOG = Logger.getLogger(DiscenteDaoTest.class.getName());

    DiscenteDao discenteDao = new DiscenteDao();
    TrabalhoDao trabalhoDao = new TrabalhoDao();
    UsuarioDao usuarioDao = new UsuarioDao();

    @Test
    @Override
    public void listarTodos(){
        List<Discente> lista = discenteDao.listarTodos();
        LOG.info("Size: "+ lista.size());
        for (Discente d: lista) {
            LOG.info("Nome: "+d.getNome());
        }
    }

    @Test
    @Override
    public void buscarPorId() {
        Usuario usuario = usuarioDao.buscarPorCpf("906369470");
        LOG.info(usuario.getNome());
    }

    @Test
    @Override
    public void buscar() {

    }

    @Test
    @Override
    public void atualizar() {

    }

    @Test
    public void mapear(){
        Persistence.createEntityManagerFactory("webiiproject").createEntityManager();
    }

    @Test
    @Override
    public void remover() {

        Discente discente = discenteDao.buscarPorId(1l);
        LOG.info(discente.getCpf());
        LOG.info(discente.getTrabalhos()+"");

        List<Trabalho> trabalhos = discente.getTrabalhos();
        for (Trabalho t: trabalhos) {
            LOG.info("TITULO: "+t.getTitulo());
        }
        LOG.info(discente.getEndereco().getEstado()+"");
    }

    @Test
    @Override
    public void adicionar() {

        Endereco endereco = new Endereco();
        endereco.setCep("521321");
        endereco.setEstado("RN");
        endereco.setRua("rua");
        endereco.setNumero(321);

        Discente discente = new Discente();
        discente.setNome("carlos");
        discente.setMatricula("1321654");
        discente.setCpf("906369470");
        discente.setReputacao("boa reputação");
        discente.setCurriculo("curriculo");
        discente.setEmail("xxx@xxx.com");
        discente.setAreasConhecimentos(Arrays.asList("area 1","area 2"));
        discente.setDataNascimento(new Date());
        discente.setEndereco(endereco);
        Trabalho trabalho = new Trabalho();
        trabalho.setTitulo("trabalho");
        trabalho.setResumo("resumo");
        trabalho.setCurtidas(100);
        trabalho.setPalavrasChave(Arrays.asList("palavra 1","palavra 2"));
        trabalho.setStatus(EnumStatusTrabalho.CONLCUIDO);

        List<Trabalho> trabalhos = new ArrayList<Trabalho>();
        trabalhos.add(trabalho);

        discente.setTrabalhos(trabalhos);

        Discente d = discenteDao.inserir(discente);

    }




}