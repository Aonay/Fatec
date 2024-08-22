#Criar uma função que gere uma lista com 5 números aleatórios. Em seguida, no programa principal solicite ao usuário que informe um número. 
# Se o número informado estiver na lista mostre a mensagem "Número encontrado", senão, solicite um novo número até que ele acerte um dos números da lista ou que escolha a opção "Desistir".

import random

flag = True

def lista_ale():
    lista = []
    for _ in range(5):
        numAle = random.randint(1,20)
        lista.append(numAle)
    return lista

lista = lista_ale()
print ("A lista gerada é: ", lista)

while flag:
    num = int(input("Digite um número: "))
    if num in lista:
            print("Número encontrado parabens!")
            flag= False
            break
    else:
            resposta = input("Número não encontrado. Continuar? (s/n): ")
            if resposta.lower() != 's':
                print("Você desistiu!")
                break

