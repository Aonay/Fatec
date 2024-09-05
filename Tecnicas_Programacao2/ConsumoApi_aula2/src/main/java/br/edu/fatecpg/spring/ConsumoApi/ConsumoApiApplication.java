package br.edu.fatecpg.spring.ConsumoApi;

import br.edu.fatecpg.spring.ConsumoApi.Model.Serie;
import br.edu.fatecpg.spring.ConsumoApi.service.ConsomeApi;
import br.edu.fatecpg.spring.ConsumoApi.service.ConveteDado;
import br.edu.fatecpg.spring.ConsumoApi.service.IConverteDado;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsumoApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ConsumoApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Ola Mundo!");
		String json = ConsomeApi.obterDado();
		System.out.println(json);
		ConveteDado conversor = new ConveteDado();
		Serie serie = conversor.obterDado(json, Serie.class);
		System.out.println(serie);
	}
}
