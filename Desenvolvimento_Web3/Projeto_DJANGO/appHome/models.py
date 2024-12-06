from django.db import models
from django.core.validators import RegexValidator

# Create your models here.
class Usuario(models.Model):
  nome = models.CharField(max_length=255)
  email = models.EmailField(unique=True)
  senha = models.CharField(max_length=255)
  foto = models.ImageField(upload_to='imagens/')

  def __str__(self):
    return self.nome
  
class Projeto(models.Model):
  nome = models.CharField(max_length=100)
  criador = models.CharField(max_length=100)
  descricao = models.CharField(max_length=255)
  capa = models.ImageField(upload_to='imagens/')
  valor = models.DecimalField(max_digits=10,decimal_places=2)
  vagas = models.IntegerField()

class Vendas(models.Model):
  idUsuario = models.IntegerField()
  idCurso = models.IntegerField()  
  curso = models.CharField(max_length=100)
  valorPago = models.DecimalField(max_digits=10,decimal_places=2)
  dtCompra = models.DateField()

class Foto(models.Model):
  titulo = models.CharField(max_length=100)
  imagem = models.ImageField(upload_to='imagens/')

class Contato(models.Model):
  nome = models.CharField(max_length=255)
  email = models.EmailField()
  telefone = models.CharField(max_length=15)
  mensagem = models.TextField(max_length=1000)
  

