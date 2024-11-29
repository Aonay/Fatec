from django.db import models

# Create your models here.from django.db import models

class Categoria(models.Model):
    nome = models.CharField(max_length=255)

    def __str__(self):
        return f"{self.nome}"

class Produto(models.Model):
    nome = models.CharField(max_length=255)
    preco = models.DecimalField(max_digits=10,decimal_places=2)
    categoria = models.ForeignKey(Categoria, on_delete=models.CASCADE) 

    # def __str__(self):
    #     return f"Nome: {self.nome} , Preço: {self.preco}, Categoria: {self.categoria}"