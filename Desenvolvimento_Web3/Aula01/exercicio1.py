import random

lista = []
r="s"

for _ in range(5):
    numAle = random.randint(1,20)
    lista.append(numAle)
print (lista)

while r=="s":

    num = int(input("Digite um numero: "))

    for x in lista:
        if num == x:
            print("Numero encontrado parabens!")
            r= str(input("Quer brincar novamente?s/n: "))
        else:
            print("Numero não encontrado")
            r = str(input("Desisitir?s/n: "))

