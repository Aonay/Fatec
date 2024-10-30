package br.edu.fatecpg.jpaApiCep;

import br.edu.fatecpg.jpaApiCep.service.ApiCep;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Pratica8JpaApiCepApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Pratica8JpaApiCepApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Ola mundo!");
		String cep =ApiCep.buscarCep(11713300);
		System.out.println(cep);





	}
}
