import datetime

class Pessoa:
    def __init__(self,_nome,_idade): 
        #CONSTRUTOR 'self' usado pra referenciar instacia como o this
        #no python as variaveis são criadas diretamente dentro do construtor
        #pass ou ... permitem criar a classe sem conteudo
    
        self.nome= _nome 
        self.idade= _idade
    def dados(self): #similar ao tostring
        print(f"Bem vindo {self.nome}, você tem {self.idade} anos.")

    def anoNasc(self):
        data = datetime.datetime.now() #importando a data de hoje
        ano = data.year #pegando apenas a ano
        return  ano - self.idade #fazendo o calculo pra saber ano de nascimenot

        
 


p1= Pessoa('Alan',33) # criando objeto
print(p1) #imprime somente a instancia

print(p1.nome)
print(p1.idade)

p1.dados()
print(f"Nasceu em {p1.anoNasc()}")



