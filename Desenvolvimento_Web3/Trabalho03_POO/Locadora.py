from Filme import Filme
from Cliente import Cliente

class Locadora:
  filmes = {}
  Clientes = {}

  def menu():
    print("╔═══════════════════════════════════╗")
    print("║      LOCADORA VIDEOBOOSTER        ║")
    print("╠───────────────────────────────────╣")
    print("║ Digite o numero da opção:         ║")
    print("║  1 - Adicionar filme              ║")
    print("║  2 - Adicionar cliente            ║")
    print("║  3 - Alugar filme                 ║")
    print("║  4 - Listar filmes                ║")
    print("║  6 - Listar clientes              ║")
    print("║  7 - Sair                         ║")
    print("╚═══════════════════════════════════╝")

  def addFilme():
    titulo= str(input("Titulo: "))
    ano = int(input("Ano Lançamento:"))
    genero = str(input("Gênero: "))
    filme = Filme(titulo,ano,genero)
    Locadora.filmes[titulo]= filme

  def addCliente():
    id= int(input("ID:"))
    nome= str(input("Nome:"))
    cliente = Cliente(id,nome)
    Locadora.Clientes[id]= cliente

  def exibirFilmes(disp=None):
    if Locadora.filmes:
      for titulo,filme in Locadora.filmes.items():
       
       estado = "Disponível" if filme.disp else "Alugado"

       if disp is None or filme.disp==disp:
       
        print(f"Titulo: {filme.titulo} Ano: {filme.ano} Genero: {filme.genero} Status : {estado}")

    else:
      print("Nenhum filme cadastrado")