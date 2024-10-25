from django import forms

class UsuarioForm(forms.Form):
  nome = forms.CharField(max_length=100)
  email = forms.EmailField()
  senha = forms.CharField(widget=forms.PasswordInput)