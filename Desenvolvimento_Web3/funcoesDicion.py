dicionario = {'Ana':'Aluna','Maria':'Professora',} #criando dicionario
print(dicionario)

dicionario['Braga']='Apresentadora' # adicionando elementos ao dicionario
print(dicionario)

del dicionario['Braga'] #remoção do dicionario é feito atravez do indice
print(dicionario)

print('Ana'in dicionario) #consultando a chave dentro do dicionario

for c,v in dicionario.items():
    print(f'\nChave: {c}')
    print(f'Valor: {v}')
    