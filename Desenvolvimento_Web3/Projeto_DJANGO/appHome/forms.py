from django import forms
from .models import Usuario

class UsuarioForm(forms.ModelForm):
    class Meta:  # M deve ser maiúsculo
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