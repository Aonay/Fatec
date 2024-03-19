using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static System.Net.Mime.MediaTypeNames;

namespace atividade3_entrada_de_dados_alan
{
    internal class Program
    {
        static void Main(string[] args)
        {
            /* 1 - Desenvolva um programa que permita a entrada do nome do usuário e exiba na tela.*/

            
            string nome;
            Console.WriteLine("Escreva seu nome: ");
            nome = Console.ReadLine();
            Console.WriteLine("Seu nome é: " + nome);
            Console.ReadKey();
            

            /*
            2 – Crie um programa que permita ao usuário entrar com dois números. Executar as quatro
            operações com esses dois números (Soma, Subtração, multiplicação, divisão).
            Não se esquecer de mostrar as respostas na tela.
            */


            
            double n1, n2, rsoma, rsub, rmult, rdiv;
            Console.WriteLine("Olá seja bem vindo! Vamos realizar algumas operações matematicas");
            Console.WriteLine("Digite o primeiro numero: ");
            n1 = Convert.ToDouble(Console.ReadLine());
            Console.WriteLine("Digite o segundo número: ");
            n2 = Convert.ToDouble(Console.ReadLine());
            rsoma = n1 + n2;
            Console.WriteLine("A SOMA dos dois números será: "+rsoma);
            rsub = n1 - n2;
            Console.WriteLine("A SUBTRAÇÂO dos dois números será: "+rsub);
            rmult = n1 * n2;
            Console.WriteLine("A MULTIPLICAÇÂO dos dois números será: "+rmult);
            rdiv = n1 / n2;
            Console.WriteLine("A DIVISÂO do primeiro pelo segundo será: "+rdiv);
            Console.WriteLine("Aperte qualquer tecla para sair");
            Console.ReadKey();
            

            /*
            3 – Desenvolva um programa e fluxograma para calcular a idade de uma pessoa, 
                entrando com o ano de nascimento e ano atual.
            */

            
            int anon, anov, idade;
            Console.WriteLine("Insira o ano do seu nascimento: ");
            anon = Convert.ToInt16(Console.ReadLine());
            Console.WriteLine("Isira a ano atual: ");
            anov = Convert.ToInt16(Console.ReadLine());
            idade = anov - anon;
            Console.WriteLine("Sua idade aproximada é de: " + idade+" anos");
            Console.WriteLine("Aperte qualquer tecla para sair");
            Console.ReadKey();


            /*4 - Elaborar um programa e fluxograma para calcular a 
            média aritmética de três números digitados pelo usuário.*/

            double n1, n2, n3, media;
            Console.WriteLine("Vamos Calcular uma média aritimética de 3 números");
            Console.WriteLine("Isira o primeiro numero: ");
            n1 = Convert.ToDouble(Console.ReadLine());
            Console.WriteLine("Insira o segundo numero: ");
            n2 = Convert.ToDouble(Console.ReadLine());
            Console.WriteLine("Insira o terceiro numero: ");
            n3 = Convert.ToDouble(Console.ReadLine());
            media = (n1 + n2 + n3) / 3;
            Console.WriteLine("A média é: "+media);
            Console.WriteLine("Aperte qualquer tecla para sair");
            Console.ReadKey();



        }

    }
}
