package com.merini.agendaspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.merini.agendaspring.model.ClassificacaoDAO;

@SpringBootApplication
public class AgendaspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendaspringApplication.class, args);
//		ClassificacaoDAO dao = new ClassificacaoDAO();
//		dao.criaTabela();
	}

}
