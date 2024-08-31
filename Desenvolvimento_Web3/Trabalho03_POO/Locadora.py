from Filme import Filme
from Cliente import Cliente

class Locadora:
  filmes = {}
  clientes = {}

  def menu():
    print("╔═══════════════════════════════════╗")
    print("║      LOCADORA VIDEOBOOSTER        ║")
    print("╠───────────────────────────────────╣")
    print("║ Digite o numero da opção:         ║")
    print("║  1 - Adicionar filme              ║")
    print("║  2 - Adicionar cliente            ║")
    print("║  3 - Alugar filme                 ║")
    print("║  4 - Listar filmes                ║")
    print("║  5 - Listar clientes              ║")
    print("║  6 - Sair                         ║")
    print("╚═══════════════════════════════════╝")

  def addFilme():
    titulo= input("Titulo:").upper()
    ano = int(input("Ano Lançamento:"))
    genero = input("Gênero:").upper()
    disp=True
    filme = Filme(titulo,ano,genero,disp)
    Locadora.filmes[titulo]= filme
    print("─── Filme adicionado com sucesso! ───\n")
    



  def addCliente():
    id= int(input("ID: "))
    nome= input("Nome: ").upper()
    cliente = Cliente(id,nome)
    Locadora.clientes[id]= cliente
    print("─── Cliente cadastrado com sucesso! ───\n")


  def alugarFilme():
    while True:
      buscFilme = input("Digite o NOME do filme que deseja alugar (ou 'sair' para cancelar): → ").strip().upper()

      if buscFilme == 'SAIR':
        return
      
      if buscFilme in Locadora.filmes:
        filme = Locadora.filmes[buscFilme]

        if filme.disp:
          print(f"O filme {filme.titulo} está diponivel")
          break
        else:
          print(f"O filme {filme.titulo} já está alugado")
      else:
        print("Titulo não encontrado, tente outro nome...")

    while True:
      buscCliente = int(input("Digite o ID do cliente (ou 'sair' para cancelar):→ "))

      if buscCliente == 'sair':
        return
      
      if buscCliente in Locadora.clientes:
        cliente = Locadora.clientes[buscCliente]
        print(f"Cliente '{cliente.nome}' encontrado ")
        break

    filme.disp = False
    print(f"──── O filme '{filme.titulo}' foi alugado para '{cliente.nome}' ────")



  def exibirFilmes(disp=None):
    filmesEncontrados = False
    print("┌"+"─"*58+"┐")
    print(f"│{'TITULO':^15}│{'ANO':^10}│{'GENERO':^15}│{'STATUS':^15}│")
    print("├"+"─"*58+"┤")
    for titulo,filme in Locadora.filmes.items():
      estado = "Disponível" if filme.disp else "Alugado"
      if disp is None or filme.disp == disp:
        print(f"│{filme.titulo:<15}│{filme.ano:^10}│{filme.genero:^15}│{estado:^15}│")
        filmesEncontrados = True
    print("└"+"─"*58+"┘")

    if not filmesEncontrados:
      if disp is None:
        print("... Nenhum filme CADASTRADO ...")
      elif disp:
        print("... Nenhum filme DISPONIVEL ...")
      else:
        print("... Nenhum filme ALUGADO ...")


  def exibirClientes():
    if Locadora.clientes:
      print("┌"+"─"*21+"┐")
      print(f"│{'ID':^5}│{'NOME':^15}│")
      print("├"+"─"*21+"┤")
      for id,cliente in Locadora.clientes.items():
        print(f"│{cliente.id:^5}│{cliente.nome:<15}│")
      print("└"+"─"*21+"┘")
    else:
      print("... Nenhum cliente cadastrado ...\n")