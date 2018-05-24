package com.dao;

import com.dominio.Discente;
import com.dominio.Docente;
import com.dominio.Usuario;

import javax.ejb.Stateless;
import java.io.Serializable;


@Stateless
public class DaoFacade implements Serializable{

    private DiscenteDao discenteDao;
    private DocenteDao docenteDao;
    private ArquivoDao arquivoDao;
    private AtividadeDao atividadeDao;
    private EnderecoDao enderecoDao;
    private IdentificacaoDao identificacaoDao;
    private MensagemDao mensagemDao;
    private MensagemGrupoDao mensagemGrupoDao;
    private TrabalhoDao trabalhoDao;
    private UsuarioDao usuarioDao;
    private ComentarioDao comentarioDao;

    public DaoFacade() {

    }

    public DiscenteDao getDiscenteDao() {
        if(this.discenteDao == null)
            setDiscenteDao(new DiscenteDao());

        return getDiscenteDao();
    }

    public void setDiscenteDao(DiscenteDao discenteDao) {
        this.discenteDao = discenteDao;
    }

    public DocenteDao getDocenteDao() {
        return docenteDao;
    }

    public void setDocenteDao(DocenteDao docenteDao) {
        this.docenteDao = docenteDao;
    }

    public ArquivoDao getArquivoDao() {
        return arquivoDao;
    }

    public void setArquivoDao(ArquivoDao arquivoDao) {
        this.arquivoDao = arquivoDao;
    }

    public AtividadeDao getAtividadeDao() {
        return atividadeDao;
    }

    public void setAtividadeDao(AtividadeDao atividadeDao) {
        this.atividadeDao = atividadeDao;
    }

    public EnderecoDao getEnderecoDao() {
        return enderecoDao;
    }

    public void setEnderecoDao(EnderecoDao enderecoDao) {
        this.enderecoDao = enderecoDao;
    }

    public IdentificacaoDao getIdentificacaoDao() {
        return identificacaoDao;
    }

    public void setIdentificacaoDao(IdentificacaoDao identificacaoDao) {
        this.identificacaoDao = identificacaoDao;
    }

    public MensagemDao getMensagemDao() {
        return mensagemDao;
    }

    public void setMensagemDao(MensagemDao mensagemDao) {
        this.mensagemDao = mensagemDao;
    }

    public MensagemGrupoDao getMensagemGrupoDao() {
        return mensagemGrupoDao;
    }

    public void setMensagemGrupoDao(MensagemGrupoDao mensagemGrupoDao) {
        this.mensagemGrupoDao = mensagemGrupoDao;
    }

    public TrabalhoDao getTrabalhoDao() {
        return trabalhoDao;
    }

    public void setTrabalhoDao(TrabalhoDao trabalhoDao) {
        this.trabalhoDao = trabalhoDao;
    }

    public UsuarioDao getUsuarioDao() {
        return usuarioDao;
    }

    public void setUsuarioDao(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    public ComentarioDao getComentarioDao() {
        return comentarioDao;
    }

    public void setComentarioDao(ComentarioDao comentarioDao) {
        this.comentarioDao = comentarioDao;
    }
}
