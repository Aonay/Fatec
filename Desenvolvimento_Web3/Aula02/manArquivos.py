

with open('texto.txt','a') as arquivo:
    arquivo.write("\nNova linha!")

#esse comando abre um arquivo pra edição ou cria se nao existir
    #primeiro paramento é o nome e tipo
    #segundo a forma de gravação

#é possivel adicionar itens de lista em um arquivo

lista = ['Ana','Julia','Duda','Bruna']
dicionario = {'id':'001','nome':'Felipe'}

with open('texto2.txt','a',encoding='utf-8') as arquivo:
    arquivo.write("\nLISTA")
    for item in lista:
        arquivo.write(f'\n{item}')

    arquivo.write("\nDICIONARIO")  
    for i,v in dicionario.items():
        arquivo.write(f'\n{i}:{v}')

    arquivo.close

#abrindo para leitura
    
with open('texto2.txt','r',encoding='utf-8') as arquivo:
    print(arquivo.read())