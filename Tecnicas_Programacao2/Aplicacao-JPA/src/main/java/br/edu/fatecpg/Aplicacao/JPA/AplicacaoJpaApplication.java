package br.edu.fatecpg.Aplicacao.JPA;

import br.edu.fatecpg.Aplicacao.JPA.model.Aluno;
import br.edu.fatecpg.Aplicacao.JPA.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class AplicacaoJpaApplication implements CommandLineRunner {
	@Autowired
	private AlunoRepository repositorio;

	public static void main(String[] args) {
		SpringApplication.run(AplicacaoJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Aluno aluno = new Aluno("Alan","228");
		repositorio.save(aluno);

		List<Aluno> alunos = repositorio.findAll();

		alunos.forEach(System.out::println);

	}
}
