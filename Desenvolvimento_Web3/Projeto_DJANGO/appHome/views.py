from django.shortcuts import render, redirect
from django.http import HttpResponse
from django.template import loader
from .forms import UsuarioForm
from .models import Usuario
from django.contrib import messages
	
def appHome(request):
	template = loader.get_template("home.html")
	return HttpResponse(template.render())

def criar_usuario(request):
	if request.method == 'POST':
		form = UsuarioForm(request.POST or None)
		if form.is_valid():
			form.save()
			messages.success(request, "Usuario cadastrado com sucesso!")
			
			return redirect('appHome')
	else:
		form = UsuarioForm()
	return render(request,'criar_usuario.html',{'form':form})

def lista_usuarios(request):
	usuarios = Usuario.objects.all().value()
	return render(request,'lista_usuarios.html',{'usuarios':usuarios})