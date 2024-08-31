from Locadora import Locadora

while True:
  Locadora.menu()

  op = int(input("Opção → "))

  if op == 1:
    print("──────── Cadastrando Filme: ─────────\n")
    while True:
      Locadora.addFilme()
      resp = input("────── Adicionar outro? S/N: → ").strip().lower()
      if resp == 'n':
        break

  elif op == 2:
    print("──────── Cadastrando Cliente: ────────\n")
    while True:
      Locadora.addCliente()
      resp = input("────── Adicionar outro? S/N: → ").strip().lower()
      if resp == "n":
        break
      
  elif op == 3:
    print("────────── Alugando Filme: ──────────\n")
    while True:
      Locadora.alugarFilme()
      resp = input("────── Alugar outro? S/N: → ").strip().lower()
      if resp == 'n':
        break
      
  elif op == 4:
    print("────────── Listando Filmes: ──────────\n")
    while True:
      op = input("Deseja listar:\n [1] disponíveis\n [2] Alugados\n [3] Todos?\n → ")

      if   op =='1':
        Locadora.exibirFilmes(True)
      elif op =='2':
        Locadora.exibirFilmes(False)
      else:
        Locadora.exibirFilmes()

      resp = input("───── Listar novamente? S/N: → ").strip().lower()
      if resp == "n":
        break

  elif op == 5:
    print("────────── Listando Clientes: ──────────\n")
    while True:
      Locadora.exibirClientes()
      resp = input("─────Listar novamente? S/N: → \n").strip().lower()
      if resp == "n":
        break


  elif op==6:
    print("Encerrango programa...")
    break


    

  

