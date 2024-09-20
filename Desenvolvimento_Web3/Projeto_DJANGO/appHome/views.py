from django.shortcuts import render, redirect
from django.http import HttpResponse
from django.template import loader
from .forms import UsuarioForm
from .models import Usuario
	
def appHome(request):
	template = loader.get_template("home.html")
	return HttpResponse(template.render())

def criar_usuario(request):
	if request.method == 'POST':
		form = UsuarioForm(request.POST)
		if form.is_valid():
			form.save()
			return redirect('lista_usuarios')
	else:
		form = UsuarioForm()
	return render(request,'criar_usuario.html',{'form':form})

def lista_usuarios(request):
	usuarios = Usuario.objects.all()
	return render(request,'lista_usuarios.html',{'usuarios':usuarios})