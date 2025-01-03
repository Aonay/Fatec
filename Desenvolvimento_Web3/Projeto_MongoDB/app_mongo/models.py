from djongo import models

# Create your models here.
class Usuario(models.Model):
  nome = models.CharField(max_length=255)
  email = models.EmailField(unique=True)
  senha = models.CharField(max_length=255)

  def __str__(self):
    return self.nome

