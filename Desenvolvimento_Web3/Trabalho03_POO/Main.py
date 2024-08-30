from Locadora import Locadora

menu = True

while menu:
  Locadora.menu()

  op = int(input("Opção → "))

  if op == 1:
    rep = True
    print("----------Cadastrando de filmes:--------- ")
    while rep:
      Locadora.addFilme()
      resp = str(input("Adicionar outro? S/N: →"))
      if resp == "n":
        rep=False
        break
      
      
  elif op == 4:
    rep = True
    while rep:
      op = input("Deseja listar: [1] disponíveis, [2] Alugados ou [3] Todos? ")

      if   op ==1:
        Locadora.exibirFilmes(True)
      elif op ==2:
        Locadora.exibirFilmes(False)
      else:
        Locadora.exibirFilmes()

      resp = str(input("Listar novamente? S/N: →"))
      if resp == "n":
        rep=False
      else:
        break
    

  

