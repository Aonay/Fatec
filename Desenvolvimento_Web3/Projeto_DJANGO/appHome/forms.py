from django import forms
from .models import Usuario,Projeto


class UsuarioForm(forms.ModelForm):
    class Meta: 
        model = Usuario
        fields = ['nome', 'email', 'senha']
        widgets = {
            'nome': forms.TextInput(attrs={'class': 'form-control', 'placeholder': 'nome completo'}),
            'email': forms.EmailInput(attrs={'class': 'form-control', 'placeholder': 'email@exemplo.com'}),
            'senha': forms.PasswordInput(attrs={'class': 'form-control', 'placeholder': 'digite sua senha'}),

        }
    def clean_email(self):
        email = self.cleaned_data.get('email')
        if Usuario.objects.filter(email=email).exists():
            raise forms.ValidationError("Este e-mail já está cadastrado.")
        return email
    
class ProjetoForm(forms.ModelForm):
    class Meta:
        model = Projeto
        fields = ['nome','criador','descricao']
        widgets = {
            'nome': forms.TextInput(attrs={'class': 'form-control', 'placeholder': 'nome do projeto'}),
            'criador': forms.TextInput(attrs={'class': 'form-control', 'placeholder': 'Nome do responsavel pelo projeto'}),
            'descricao': forms.Textarea(attrs={'class': 'form-control', 'placeholder': 'descreve brevemente o projeto'}),
            
        }

class FormLogin(forms.ModelForm):
    class Meta:
        model = Usuario
        fields = ('email','senha')

        widgets = {
            'email': forms.EmailInput(attrs={'class': 'form-control', 'placeholder': 'email@exemplo.com'}),
            'senha': forms.PasswordInput(attrs={'class': 'form-control', 'placeholder': 'digite sua senha'}),
        }