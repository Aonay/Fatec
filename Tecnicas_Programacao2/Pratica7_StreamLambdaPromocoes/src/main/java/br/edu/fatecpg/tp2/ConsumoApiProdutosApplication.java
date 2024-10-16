package br.edu.fatecpg.tp2;

import br.edu.fatecpg.tp2.services.ConsomeApi;
import br.edu.fatecpg.tp2.services.ConverterDado;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class ConsumoApiProdutosApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(ConsumoApiProdutosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Testadn o JsonNode");
		String json = ConsomeApi.obterDado();
		JsonNode jsonNode = ConverterDado.listaObjetos(json);

		List<JsonNode> jsonList = ConverterDado.jsonList(jsonNode);
		jsonList.forEach(System.out::println);
		List<String> listaImperd = ConverterDado.buscarFaixaPreco(jsonList,30);
		System.out.println(listaImperd);



	}
}
