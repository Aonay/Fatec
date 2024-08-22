#Estrutura Condicional

nota1 = 1
nota2 = 8
media = (nota1+nota2)/2


print(f"Média: {media}")

if media>=6: # os : indicam que a proxima linha é a continuação do bloco de codigo
    print("Aprovado!") # pra ser considerada continuação deve haver o espaçamento duplo no inicio
elif media ==5:
    print("Recuperação!")
else:
    print("Reprovado!")

num = 10
if num>0: print("Maior")  # escrevendo na mesma linha

num2=0
print("Maior") if num>10 else print("Menor") #semelhante a operador ternario


med=5
print("AProvado!") if med==10 else print("passou...") if med>=6 else print("Reprovou...") #usando mais de duas condições



print("Fim do codigo")