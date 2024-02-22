package com.merini.agendaspring.model;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class ClassificacaoDAO extends DAOAbstrato 
{
	private static String JdbcUrl="jdbc:derby:agendaDerby;create=true";
	private String sqlDeletaClassificacao = "DELETE FROM classificacao WHERE nomeclassificacao = '";
	private String sqlCriaTabelaClassif = "CREATE TABLE classificacao(idclassificacao INT NOT NULL GENERATED ALWAYS AS IDENTITY, "
			+ "nomeclassificacao VARCHAR(70), cor VARCHAR(200),  descricao VARCHAR(700), PRIMARY KEY(idclassificacao))";
	private String sqlCarregaClassificacao = "SELECT * FROM classificacao WHERE nomeclassificacao = '";
	private String sqlCarregaClassificacaoPorId = "SELECT * FROM classificacao WHERE idclassificacao = '";

	
	@Override
	public Object carregar(String nomeClasssificacao) 
	{
		Connection connection = conecta();
		Classificacao classificacao = new Classificacao();
		try 
		{
				PreparedStatement preparedStatement = connection.prepareStatement(sqlCarregaClassificacao+nomeClasssificacao+"'");
				ResultSet resultSet = preparedStatement.executeQuery();
				resultSet.next();
				classificacao.setNomeclassificacao(resultSet.getString("nomeclassificacao"));
				classificacao.setCor(resultSet.getString("Cor"));
				classificacao.setDescricao(resultSet.getString("Descricao"));
				classificacao.setIdclassificacao(resultSet.getInt("idclassificacao"));
				
				resultSet.close();
				preparedStatement.close();
				connection.close();
					System.out.println("classificação recuperada : "+classificacao.getNomeclassificacao());
				shutDown();
				return classificacao;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();		
		}
		return null;
	}
	
	public Object carregar(Integer idClasssificacao) 
	{
		Connection connection = conecta();
		Classificacao classificacao = new Classificacao();
		try 
		{
				PreparedStatement preparedStatement = connection.prepareStatement(sqlCarregaClassificacao+String.valueOf(idClasssificacao)+"'");
				ResultSet resultSet = preparedStatement.executeQuery();
				resultSet.next();
				classificacao.setNomeclassificacao(resultSet.getString("nomeclassificacao"));
				classificacao.setCor(resultSet.getString("Cor"));
				classificacao.setDescricao(resultSet.getString("Descricao"));
				classificacao.setIdclassificacao(resultSet.getInt("idclassificacao"));
				
				resultSet.close();
				preparedStatement.close();
				connection.close();
					System.out.println("classificação recuperada : "+classificacao.getNomeclassificacao());
				shutDown();
				return classificacao;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();		
		}
		return null;
	}
	
	public void criaTabela()
	{
	
		Connection connection =conecta();
		try 
		{
			Statement stmt = connection.createStatement();
			int resultado = stmt.executeUpdate(sqlCriaTabelaClassif);
				System.out.println(String.valueOf(resultado));
			stmt.close();
			connection.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();		
		}
		shutDown();
	}
	

	@Override
	public void editar(Object objeto) 
	{
		Classificacao classificacao = (Classificacao)objeto;
		String sqlEditar = "UPDATE classificacao SET "+
						   " nomeclassificacao = '"+classificacao.getNomeclassificacao()+
				           "', cor = '"+classificacao.getCor()+
						   "', descricao = '"+classificacao.getDescricao()+"' WHERE "+
						   " idclassificacao = "+String.valueOf(classificacao.getIdclassificacao());
		System.out.println("dao.editar "+sqlEditar);

		Connection connection =conecta();
		try 
		{
			Statement stmt = connection.createStatement();
			int resultado = stmt.executeUpdate(sqlEditar);
				System.out.println(String.valueOf(resultado));
			stmt.close();
			connection.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();		
		}
		shutDown();
		
	}

	public int excluir(String nomeClassificacao) 
	{
		int resultado=0;
		Connection connection = conecta();
		try 
		{
			Statement stmt = connection.createStatement();
			String sql = sqlDeletaClassificacao+nomeClassificacao+"'";
			System.out.println(sql);
			resultado = stmt.executeUpdate(sql);
				System.out.println("registro classificação excluído, status code : "+String.valueOf(resultado));
			stmt.close();
			connection.close();	
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();		
		}
		shutDown();
		return resultado;
	}

	@Override
	public Object gravar(Object entidade) 
	{
		Classificacao cl =(Classificacao) entidade;
		String sqlInsertClassif = "INSERT INTO classificacao(nomeclassificacao, cor, descricao) values ('"
				+ cl.getNomeclassificacao()+"', '"+cl.getCor()+"', '"
				+ cl.getDescricao()+"')";
		int resultado=0;
		try 
		{
			Connection connection = DriverManager.getConnection(JdbcUrl);
				System.out.println("conectado");
			Statement stmt = connection.createStatement();
			resultado = stmt.executeUpdate(sqlInsertClassif);
				System.out.println("registro classificação inserido - "+String.valueOf(resultado));
			stmt.close();
			connection.close();	
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();		
		}
		shutDown();
		return resultado;
	}

	public int gravar(String sql) 
	{
		String sqlInsertClassif = sql;
		int resultado=0;
		try 
		{
			Connection connection = DriverManager.getConnection(JdbcUrl);
				System.out.println("conectado");
			Statement stmt = connection.createStatement();
			resultado = stmt.executeUpdate(sqlInsertClassif);
				System.out.println("registro classificação inserido - "+String.valueOf(resultado));
			stmt.close();
			connection.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();		
		}
		shutDown();
		return resultado;
	}

	
	@Override
	public List obterTodosNomes() 
	{
		Connection connection = conecta();
		try 
		{
				PreparedStatement preparedStatement = connection.prepareStatement
				("select nomeclassificacao from classificacao");
				ResultSet resultSet = preparedStatement.executeQuery();
				String name;
				ArrayList<String> arrayNomesClassif = new ArrayList<String>();
				while(resultSet.next())
				{
					name = resultSet.getString("nomeclassificacao").trim();
					System.out.printf("nome da classificação : %s\n",name);
					arrayNomesClassif.add(name);
				}
				resultSet.close();
				preparedStatement.close();
				connection.close();
					System.out.println("nome das classificações recuperado");
				shutDown();
				return (List) arrayNomesClassif;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();		
		}
		return null;		
	}
	
	public Connection conecta()
	{
		Connection connection =null;
	    try {
	    	DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());	
			connection = DriverManager.getConnection(JdbcUrl);	} 
	    catch (SQLException e) {
			e.printStackTrace();	}
			System.out.println("conectado");
		return connection;		
	}
	

	public void shutDown() 
	{
		System.out.println("public void shutDown() ");
		String shutdownUrl = "jdbc:derby:;shutdown=true";
		try 
		{			
			DriverManager.getConnection(shutdownUrl);
				System.out.println("shutdown1");
		} 
		catch (SQLException e) 
		{
			if (e.getSQLState().equals("XJ015"))
				{System.out.println("shutdown2");}
			else
				{e.printStackTrace();}
		}
	}

}
