from django.shortcuts import render, redirect
from .forms import UsuarioForm
from .mongo import client
from django.template import loader

db=client.get_database('db_recycle')

def sucesso(request):
    return render(request,'sucesso.html')

def cadastrar_usuario(request):
    if request.method == 'POST':
        form = UsuarioForm(request.POST)
        if form.is_valid():
            nome = form.cleaned_data['nome']
            email = form.cleaned_data['email']
            senha = form.cleaned_data['senha']


            db.usuarios.insert_one({
                'nome':nome,
                'email':email,
                'senha':senha
            })

            return redirect('sucesso')
    else:
        form = UsuarioForm()
    
    return render(request,'cadastrar_usuario.html',{'form':form})



            





