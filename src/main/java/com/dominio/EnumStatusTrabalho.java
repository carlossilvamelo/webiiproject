package com.dominio;

public enum EnumStatusTrabalho {
	EM_ANDAMENTO(0, "em andamento"),
	CONLCUIDO(1, "concluido");
	
	private int valor;
	private String nome;
	
	private EnumStatusTrabalho(int valor, String nome){
		this.valor = valor;
		this.nome = nome;
	}
	
	
	@Override
	public String toString() {
		return this.nome;
	}
	
	public static EnumStatusTrabalho getStatusByNome(String nome_status){
		EnumStatusTrabalho[] valores = EnumStatusTrabalho.values();
		EnumStatusTrabalho status = null;
		for(EnumStatusTrabalho cadaStatus : valores){
			if(cadaStatus.toString() == nome_status)
				status = cadaStatus;
		}
		return status;
	}
}
