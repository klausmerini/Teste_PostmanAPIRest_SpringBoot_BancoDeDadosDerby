package com.merini.agendaspring.controler;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.merini.agendaspring.model.Classificacao;
import com.merini.agendaspring.model.ClassificacaoDAO;

@RestController
@RequestMapping("/classificacao")
public class ClassificacaoAPIService 
{
	private Classificacao classificacao;
	private ClassificacaoDAO dao = new ClassificacaoDAO();
	
	@GetMapping("{idClassificacao}")
	public Classificacao getClassificacaoDetails(String idClassificacao)
	{
		classificacao = (Classificacao) dao.carregar(Integer.valueOf(idClassificacao));
		String retorno = classificacao.getNomeclassificacao()+", "+classificacao.getDescricao() ;
		System.out.println(retorno);
		return classificacao;		
	}
	
	@GetMapping("todos")
	public ArrayList<String> getTodosClassificacaoDetails(String idClassificacao)
	{
		ArrayList<String> nomesClassificacoes  = (ArrayList<String> ) dao.obterTodosNomes();
		return nomesClassificacoes;		
	}
	
	@PostMapping
	public String createClassificacao(@RequestBody Classificacao classificacao)
	{
		this.classificacao=classificacao;
		String resultado = String.valueOf(dao.gravar(classificacao));
		return "Criação bem sucedida! "+resultado;		
	}	
	
	@PutMapping
	public String updateClassificacao(Classificacao classificacao)
	{
		this.classificacao	= classificacao;
		dao.editar(classificacao);
		return "Classificacao atualizada com sucesso";
		
	}
	
	@DeleteMapping("{idClassificacao}")
	public String deleteClassificacaoDetails(String idClassificacao)
	{
		this.classificacao=null;
		return "Classificacao deleted Succefully";
	}
}


/*


@RestController
@RequestMapping("/classificacao")
public class ClassificacaoAPIService 
{
	private Classificacao classificacao;
	
	@GetMapping("{idClassificacao}")
	public Classificacao getClassificacaoDetails(String idClassificacao)
	{
		Classificacao classificacao = new Classificacao("Comercial","testando o componente","cinza", 7);
		return classificacao ;		
	}
	
	@PostMapping
	public String createClassificacao(@RequestBody Classificacao classificacao)
	{
		this.classificacao=classificacao;
		return "Criação bem sucedida!";		
	}	
	
	@PutMapping
	public String updateClassificacao(Classificacao classificacao)
	{
		this.classificacao	= classificacao;
		return "Classificacao atualizada com sucesso";
		
	}
	
	@DeleteMapping("{idClassificacao}")
	public String deleteClassificacaoDetails(String idClassificacao)
	{
		this.classificacao=null;
		return "Classificacao deleted Succefully";
	}
	
}	

*/
