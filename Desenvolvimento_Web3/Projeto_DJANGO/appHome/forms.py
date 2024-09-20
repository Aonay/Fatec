from django import forms
from .models import Usuario

class UsuarioForm(forms.ModelForm):
    class Meta:  # M deve ser maiúsculo
        model = Usuario
        fields = ['nome', 'sobrenome', 'idade', 'curso']
        widgets = {
            'nome': forms.TextInput(attrs={'class': 'form-control', 'placeholder': 'Nome'}),
            'sobrenome': forms.TextInput(attrs={'class': 'form-control', 'placeholder': 'Sobrenome'}),
            'idade': forms.NumberInput(attrs={'class': 'form-control', 'placeholder': 'Idade'}),
            'curso': forms.TextInput(attrs={'class': 'form-control', 'placeholder': 'Curso'}),
        }