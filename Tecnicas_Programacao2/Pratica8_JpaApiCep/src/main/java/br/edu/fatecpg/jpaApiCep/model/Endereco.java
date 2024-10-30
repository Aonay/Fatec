package br.edu.fatecpg.jpaApiCep.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;


@Entity
@Table(name = "endereco")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(unique = true)
    private String cep;
    @Column
    @JsonAlias("logradouro")
    private String rua;
    @Column
    private String bairro;
    @Column
    @JsonAlias("localidade")
    private String cidade;
    @Column
    private String uf;

    public Endereco(String cep, String rua, String bairro, String cidade, String uf) {
        this.cep = cep;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
    }
}
