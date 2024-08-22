import datetime

data = datetime.date.today() #pegar a data atual
print(data)

lista = ["A","B","C","D"]
print(lista[2])
print(lista)

lista1 = []
print(lista1)
lista1.append("Ana") # add 1 tem por vez
print(lista1)

lista1.extend(["João","Lucas","Karina"]) # adiciona mais de um elemento na lista deve-se usar colchetes
print(lista1)

lista1.pop(1) # remover um elemento de lista com indice
print(lista1)

lista1.pop(-1) # remover um elemento de lista com indice (-1 remove o ultimo adicionado)
print(lista1)

#convertendo string em lista
nomes = "Gil;Bia;Ana;Tina"
print(type(nomes))
print(nomes)

lista2 = nomes.split(";") # dentro da função split se coloca o caractere separador
print(lista2)


datas = str(data).split("-") #convertendo data em string depois tranhsfomrando em lista
print(datas)
print(datas[0])
print(f"Ano: {datas[0]}")

lista3 = ["Zero", "Dois", "Quatro"] #ordenando de forma crescente
lista3.sort()
print(lista3)

lista3.sort(reverse=True) #ordenando em ordem descrescente
print(lista3)



