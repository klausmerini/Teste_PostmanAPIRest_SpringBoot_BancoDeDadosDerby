package com.merini.agendaspring.model;

import java.util.List;

public abstract class DAOAbstrato 
{	
	protected static Comentario c = new Comentario();
	
	
	public DAOAbstrato()
	{
//		em  = EM.getInstance().getEm();
	}


	public abstract void editar(Object objeto) ;
	
//	@Override
	public void excluir(Integer id) 
	{		// TODO Auto-generated method stub
		
	}

//	@Override
	public abstract Object gravar(Object entidade);


//	@Override
	public List obterTodos() {
		// TODO Auto-generated method stub
		return null;
	}


//	@Override
	public abstract List obterTodosNomes() ;
	


//	@Override
	public Integer recuperaIdPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}


//	@Override
	public Object recuperaPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}


	public Object carregar(String nomeClasssificacao) {
		// TODO Auto-generated method stub
		return null;
	}

}
