package com.merini.agendaspring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AgendaspringApplicationTests {

	private static String JdbcUrl="jdbc:derby:agendaDerby;create=true";
	private static String sqlRecuperaTodosNomesClassif = "SELECT nomeclassificacao FROM classificacao";
	
	@Test
	void contextLoads() {
		registraDriveEmbeded();
		Connection connection = conecta();		
		try 
		{			   
				PreparedStatement preparedStatement = connection.prepareStatement
				(sqlRecuperaTodosNomesClassif);
				ResultSet resultSet = preparedStatement.executeQuery();
				String name;
				while(resultSet.next())
				{
					name = resultSet.getString("nomeclassificacao").trim();
					System.out.printf("nome da classificação : %s\n",name);
				}
				resultSet.close();
				preparedStatement.close();
				connection.close();
					System.out.println("nome das classificações recuperado");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();		
		}
		shutDown();
	}
	
	
	public Connection conecta()
	{
			System.out.println("public Connection conecta()");
		Connection connection =null;
	    try {
			connection = DriverManager.getConnection(JdbcUrl);	} 
	    catch (SQLException e) {
			e.printStackTrace();	}
			System.out.println("conectado");
		return connection;		
	}
	
	public void shutDown() 
	{
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

	
	public void registraDriveEmbeded()
	{
		try {
			System.out.println("registerDriver");
			DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());		} 
		catch (SQLException e) {
			e.printStackTrace();		}
	}

}
