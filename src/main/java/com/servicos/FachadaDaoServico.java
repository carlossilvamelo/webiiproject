package com.servicos;

import com.dao.*;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.io.Serializable;


@Stateless
public class FachadaDaoServico implements Serializable{

    @EJB
    private DiscenteDao discenteDao;
    @EJB
    private DocenteDao docenteDao;
    @EJB
    private ArquivoDao arquivoDao;
    @EJB
    private AtividadeDao atividadeDao;
    @EJB
    private EnderecoDao enderecoDao;
    @EJB
    private IdentificacaoDao identificacaoDao;
    @EJB
    private MensagemDao mensagemDao;
    @EJB
    private MensagemGrupoDao mensagemGrupoDao;
    @EJB
    private TrabalhoDao trabalhoDao;
    @EJB
    private UsuarioDao usuarioDao;
    @EJB
    private ComentarioDao comentarioDao;

    public FachadaDaoServico() {

    }

    public DiscenteDao getDiscenteDao() {
        return discenteDao;
    }

    public DocenteDao getDocenteDao() {
        return docenteDao;
    }

    public ArquivoDao getArquivoDao() {
        return arquivoDao;
    }

    public AtividadeDao getAtividadeDao() {
        return atividadeDao;
    }

    public EnderecoDao getEnderecoDao() {
        return enderecoDao;
    }

    public IdentificacaoDao getIdentificacaoDao() {
        return identificacaoDao;
    }

    public MensagemDao getMensagemDao() {
        return mensagemDao;
    }

    public MensagemGrupoDao getMensagemGrupoDao() {
        return mensagemGrupoDao;
    }

    public TrabalhoDao getTrabalhoDao() {
        return trabalhoDao;
    }

    public UsuarioDao getUsuarioDao() {
        return usuarioDao;
    }

    public ComentarioDao getComentarioDao() {
        return comentarioDao;
    }
}
