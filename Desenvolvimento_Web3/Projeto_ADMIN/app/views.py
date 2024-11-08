from django.shortcuts import render, redirect
from app.models import Produto
from app.forms import ProdutoForm

# Create your views here.

def index(request):
    produtos = Produto.objects.all()

    formP = ProdutoForm(request.POST or None)
    if request.POST:
        if formP.is_valid():
            formP.save()
            return redirect('index')

    return render(request, 'index.html',{'produtos':produtos,'form':formP})





    
