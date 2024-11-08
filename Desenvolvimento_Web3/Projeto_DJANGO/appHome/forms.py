from django import forms
from .models import Usuario,Projeto,Foto
from django.core.exceptions import ValidationError


class UsuarioForm(forms.ModelForm):
    class Meta: 
        model = Usuario
        fields = ['nome', 'email', 'senha','foto']
        widgets = {
            'nome': forms.TextInput(attrs={'class': 'form-control', 'placeholder': 'nome completo'}),
            'email': forms.EmailInput(attrs={'class': 'form-control', 'placeholder': 'email@exemplo.com'}),
            'senha': forms.PasswordInput(attrs={'class': 'form-control', 'placeholder': 'digite sua senha'}),
            'foto': forms.FileInput(attrs={'accept': 'image/*','class': 'form-control', 'placeholder': 'selecione'}),

        }
    def clean_email(self):
        email = self.cleaned_data.get('email')
        if Usuario.objects.filter(email=email).exists():
            raise forms.ValidationError("Este e-mail já está cadastrado.")
        return email
    
class ProjetoForm(forms.ModelForm):
    class Meta:
        model = Projeto
        fields = ['nome','criador','descricao','capa']
        widgets = {
            'nome': forms.TextInput(attrs={'class': 'form-control', 'placeholder': 'nome do projeto'}),
            'criador': forms.TextInput(attrs={'class': 'form-control', 'placeholder': 'Nome do responsavel pelo projeto'}),
            'descricao': forms.Textarea(attrs={'class': 'form-control', 'placeholder': 'descreve brevemente o projeto'}),
            'capa': forms.FileInput(attrs={'accept': 'image/*','class': 'form-control', 'placeholder': 'selecione'}),
            
        }

class FormLogin(forms.ModelForm):
    class Meta:
        model = Usuario
        fields = ('email','senha')

        widgets = {
            'email': forms.EmailInput(attrs={'class': 'form-control', 'placeholder': 'email@exemplo.com'}),
            'senha': forms.PasswordInput(attrs={'class': 'form-control', 'placeholder': 'digite sua senha'}),
        }

class RedefinirSenhaForm(forms.Form):
    senha_atual = forms.CharField(widget=forms.PasswordInput(attrs={'class': 'form-control', 'placeholder': 'digite sua atual'}))
    nova_senha = forms.CharField(widget=forms.PasswordInput(attrs={'class': 'form-control', 'placeholder': 'digite a nova senha'}))
    confirmacao_senha = forms.CharField(widget=forms.PasswordInput(attrs={'class': 'form-control', 'placeholder': 'confirme a nova senha'}))

class FotoForm(forms.ModelForm):
    class Meta:
        model = Foto
        fields = ['titulo','imagem']

        widgets = {
            'titulo': forms.TextInput(attrs={'class': 'form-control', 'placeholder': 'Digite um titulo para imagem'}),
            'imagem': forms.FileInput(attrs={'accept': 'image/*','class': 'form-control', 'placeholder': 'selecione'}),
        }