<?php 

class Comissionado extends Funcionario{
    private $vendas;

    public function __construct($_codigo,$_nome, $_valorHora, $_horasTrabalhadas,$_vendas){
        
        //herda o construtor da classe Pessoa 
        parent:: __construct($_codigo, $_nome, $_valorHora, $_horasTrabalhadas);
        
        //adiciona somente o novo atributo de Aluno 
        $this->vendas = $_vendas;

    }
    public function calcularSalario(){
        return ($this->valorHora*$this->horasTrabalhadas)+($this->vendas*0.15);
    }

}



?>