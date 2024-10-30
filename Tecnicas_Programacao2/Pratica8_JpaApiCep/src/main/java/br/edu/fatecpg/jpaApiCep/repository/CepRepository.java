package br.edu.fatecpg.jpaApiCep.repository;

import br.edu.fatecpg.jpaApiCep.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CepRepository extends JpaRepository<Endereco, Long> {
}
