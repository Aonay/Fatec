1
#1. Crie um programa em Python que permita ao usuário cadastrar seus contatos com
#nome e número de telefone. O programa deve utilizar um dicionário para armazenar os
#contatos, onde o nome é a chave e o número de telefone é o valor. O programa deve
#permitir adicionar novos contatos, exibir todos os contatos cadastrados e buscar um
#contato pelo nome


contatos = {}
menu=True

while menu:

    print("\nAGENDA")
    print("----------------------------------------")
    print("\nEscolha uma opção: ")
    print("1 - Cadastrar")
    print("2 - Exibir todos")
    print("3 - Buscar contato")
    print("4 - Sair")
    print("----------------------------------------")

    op = int(input())
    #adicionar contatos

    if op == 1:
        repetir = True
        while repetir:
            nome = str(input("Digite o nome:"))
            tel = str(input("Digite o telefone:"))
            contatos[nome]=tel
            add = str(input("   Deseja adcionar outro? S/N: "))
            if add =='n':
                repetir=False


    #exibir todos os contatos

    elif op == 2:
        if contatos:
            print("\nContatos: ")
            for n,t in contatos.items():
                print(f"Nome: {n}    Telefone: {t}")
        else:
            print("***********A agenda ainda está vazia!***************")

    #Buscar pelo nome
            
    elif op == 3:
        buscar=True
        while buscar:
            busc = str(input("Digite o nome: "))
            print("********* Resultado ***********")
            c=0
            for n,t in contatos.items():
                
                if busc == n:
                    print(f"Nome: {n}    Telefone: {t}")
                    c+=1
            if c==0:
                print("\nContato não encotrado...")
            rep = str(input("\nDeseja buscar outro? S/N: " ))
            if rep == 'n':
                buscar = False
                
    elif op == 4:
        print("Fechando Agenda...")
        menu=False
        
    else:
        print("Opção invalida!")
        
                