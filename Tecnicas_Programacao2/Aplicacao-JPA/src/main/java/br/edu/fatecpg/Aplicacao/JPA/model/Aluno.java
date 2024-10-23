package br.edu.fatecpg.Aplicacao.JPA.model;

import jakarta.persistence.*;

@Entity
@Table(name="alunos")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name= "nome_completo")
    private String nome;
    @Column(unique = true)
    private String cpf;

    public Aluno(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }

    public Aluno(){  }
}
