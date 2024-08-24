from Pessoa import Pessoa #from o nome do arquivo import o nome da classe
class Aluno(Pessoa):#aluno esta herdando da classe pessoa
    def __init__(self, _nome, _idade,_matricula,_curso):
        Pessoa.__init__(self,_nome,_idade)
        self.matricula = _matricula
        self.curso = _curso

    def dados(self): #sobrescrevendo o motodo da classe pai
        print(f"Ola {self.nome}, você tem {self.idade}, sua matricula é: {self.matricula} do Curso: {self.curso}")

a1 = Aluno("Julio",32,"654654","DSM")
print(a1)
a1.dados()

del(a1) # Deleta o objeto instanciado
