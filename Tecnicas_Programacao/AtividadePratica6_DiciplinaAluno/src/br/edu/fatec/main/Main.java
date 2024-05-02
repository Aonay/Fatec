package br.edu.fatec.main;

import java.util.Scanner;

import br.edu.fatec.model.Aluno;
import br.edu.fatec.model.Diciplina;



public class Main {

	public static void main(String[] args) {
		
		var scan = new Scanner(System.in);
		
		//populando objeto Pessoa e Enedereco//
				System.out.print("Nome da Diciplina: ");
				String nomed = scan.nextLine();
				System.out.print("Sigla: ");
				String sigla = scan.nextLine();
				System.out.print("Codigo do Curso: ");
				int codigo = scan.nextInt();
				scan.nextLine();
				
				System.out.println("Nome do Aluno: ");
				String nomea = scan.nextLine();
				System.out.println("Matricula: ");
				int matricula = scan.nextInt();
				scan.nextLine();
				System.out.println("Curso: ");
				String curso = scan.nextLine();
				
				//instanciando Objeto Pessoa//
				
				var dcp1 = new Diciplina(nomed, sigla, codigo);
				var aln1 = new Aluno(nomea, matricula, curso);
				dcp1.setAluno(aln1);
				
				System.out.println(dcp1.toString());
			
				
				scan.close();
		

	}

}
