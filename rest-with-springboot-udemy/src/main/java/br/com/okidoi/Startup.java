package br.com.okidoi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Startup {

	//OBSERVACAO: Acesse no browser
	//http://localhost:8080/greeting?name=Marcio
	
	public static void main(String[] args) {
		SpringApplication.run(Startup.class, args);
	}
}
