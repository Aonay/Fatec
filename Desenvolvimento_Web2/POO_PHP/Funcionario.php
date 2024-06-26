<?php


class Funcionario
{

  //atributos
  protected $codigo;
  protected $nome;
  protected $valorHora;
  protected $horasTrabalhadas;


  //método construtor
  public function __construct($_codigo, $_nome, $_valorHora, $_horasTrabalhadas)
  {
    $this->codigo = $_codigo;
    $this->nome = $_nome;
    $this->valorHora = $_valorHora;
    $this->horasTrabalhadas = $_horasTrabalhadas;
  }

  //métodos para acesso (encapsulamento)
  public function setCodigo($_codigo)
  {
    $this->codigo = $_codigo;
  }

  public function getCodigo()
  {
    return $this->codigo;
  }

  public function setNome($_nome)
  {
    $this->nome = $_nome;
  }

  public function getNome()
  {
    return $this->nome;
  }

  public function setValorHora($_valorHora)
  {
    $this->valorHora = $_valorHora;
  }

  public function getValorHora()
  {
    return $this->valorHora;
  }

  public function setHorasTrabalhadas($_horasTrabalhadas)
  {
    $this->horasTrabalhadas = $_horasTrabalhadas;
  }

  public function getHorasTrabalhadas()
  {
    return $this->horasTrabalhadas;
  }


  public function calcularSalario()
  {
    return $this->valorHora * $this->horasTrabalhadas;
  }
}
