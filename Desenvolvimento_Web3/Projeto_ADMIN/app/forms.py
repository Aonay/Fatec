from django import forms
from app.models import Produto

class ProdutoForm(forms.ModelForm):
    class Meta:
        model = Produto
        fields = ('nome','preco','categoria')