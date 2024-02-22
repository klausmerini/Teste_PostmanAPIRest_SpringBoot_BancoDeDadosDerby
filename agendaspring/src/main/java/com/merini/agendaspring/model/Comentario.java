package com.merini.agendaspring.model;

public class Comentario 
{
	public static Comentario c = new Comentario();
	
	
	public Comentario() {
		
	}
	
	public void comentaErro(String nomeErro)
	{
		System.out.println("!!!! "+nomeErro);
	}
	
	public void comentaLocalizacao(String nomeMetodo)
	{
		System.out.println("  *** "+nomeMetodo);
	}	
	
	public void comentaLocalizacao(String nomeMetodo, String valorexibido)
	{
		System.out.println("  *** "+nomeMetodo+" - "+valorexibido);
	}
	
	
	public void comentaLocalizCamadaControle(String nomeMetodo, String nomeClasse, String valorexibido)
	{
		System.out.println("	C*** "+nomeClasse+"."+nomeMetodo+" - "+valorexibido);
	}
		
	
	public void comentaLocalizCamadaDAO(String nomeMetodo, String nomeClasse, String valorexibido)
	{
		System.out.println("		 D*** "+nomeClasse+"."+nomeMetodo+" , par�metro recebido : - "+valorexibido);
	}
	

	public void comentaLocalizCamadaView(String nomeMetodo, String nomeClasse, String valorexibido)
	{
		System.out.println("			V*** "+nomeClasse+"."+nomeMetodo+" - "+valorexibido);
	}
	
	public void comentaValor(String nomeObjeto, String valorexibido)
	{
		System.out.println("   ."+nomeObjeto+" - "+valorexibido);
	}
	
	public void comentaValorDAO(String nomeObjeto, String valorexibido)
	{
		System.out.println("			."+nomeObjeto+" - "+valorexibido);
	}
	
	
	public void comentaIteracao(String nomeObjeto, String valorexibido)
	{
		System.out.println("    - "+nomeObjeto+" - "+valorexibido);
	}
	
	public void comentaIteracao(String valorexibido)
	{
		System.out.println("	- "+valorexibido);
	}
	
	public void comentaIteracaoControle(String valorexibido)
	{
		System.out.println("		- "+valorexibido);
	}
	
	public void comentaIteracaoDAO(String valorexibido)
	{
		System.out.println("		   - "+valorexibido);
	}
	
	public void comentaIteracaoView(String valorexibido)
	{
		System.out.println("	  			- "+valorexibido);
	}	
	
	

}
