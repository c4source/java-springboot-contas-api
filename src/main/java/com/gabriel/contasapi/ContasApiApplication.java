package com.gabriel.contasapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // --> Isto é uma ANOTAÇÃO.
public class ContasApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContasApiApplication.class, args); // Spring inicializando a aplicacao

		 /*
		 	  SpringBot iniciou um servidor WEB embutido chamado tomCAT
			  Que recebe requisicoes no http:/localhost:8080 no meu PC

			 Nosso PC vira um servidor: porta 8080 à espera de requisicoes.

			lembrando:
			-- Servidor = algo que fica disponível para receber requisições e fornecer serviços/respostas. --

		  */


	}

}
