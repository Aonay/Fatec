package br.edu.fatecpg.tp2.Pratica3_SpringSemWeb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSemWebApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringSemWebApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//INICIO (CODIGO SEM WEB)

		System.out.println("Ola mundo!");

	}	//FIM
}
