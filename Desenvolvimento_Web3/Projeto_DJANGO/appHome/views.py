from datetime import timedelta
from django.shortcuts import render, redirect
from .forms import UsuarioForm,ProjetoForm, FormLogin
from .models import Usuario,Projeto
from django.contrib import messages
from django.contrib.auth.hashers import make_password,check_password
from django.contrib.auth import logout


	
def appHome(request):
	return render(request,'home.html', {'messages': messages.get_messages(request),'exibir_mensagens':True})


def criar_usuario(request):
	if request.method == 'POST':
		form = UsuarioForm(request.POST or None)
		if form.is_valid():
			usuario = form.save(commit=False)
			usuario.senha = make_password(form.cleaned_data['senha'])
			usuario.save()
			messages.success(request, "Usuario cadastrado com sucesso!")
			
			return redirect('appHome')
	else:
		form = UsuarioForm()
	return render(request,'criar_usuario.html',{'form':form})


def lista_usuarios(request):
	usuarios = Usuario.objects.all().values()
	return render(request,'lista_usuarios.html',{'usuarios':usuarios})


def criar_projeto(request):
	if request.method == 'POST':
		form = ProjetoForm(request.POST or None)
		if form.is_valid():
			form.save()
			messages.success(request, "Projeto cadastrado com sucesso!")
			return redirect('appHome')
	else:
		form = ProjetoForm()
	return render(request,'criar_projeto.html',{'form':form})


def lista_projetos(request):
	projetos = Projeto.objects.all().values()
	return render(request,'lista_projetos.html',{'projetos':projetos})


def form_login(request):
	formLogin = FormLogin(request.POST or None)

	if request.POST:
		_email = request.POST['email']
		_senha = request.POST['senha']


		try:
			usuario = Usuario.objects.get(email=_email)

			if check_password(_senha,usuario.senha):
				#sessao
				request.session.set_expiry(timedelta(seconds=20))
				#variaveis de sesao
				request.session['email'] = _email
				return redirect('dashboard')
	
			else:
				messages.error(request, "Senha ou usuario incorretos")
		
		except Usuario.DoesNotExist:
			messages.error(request,'Senha ou usuario incorretos')

	context = {
		'form': formLogin,
		'exibir_mensagens':False,
	}
	return render (request, 'form-login.html',context)



def dashboard(request):
	if 'email' not in request.session:
		return redirect('appHome')
	
	email = request.session.get('email')

	context = {
		'username':email
	}
	return render(request,'dashboard.html',context)


def userLogout(request):
	logout(request)
	messages.success(request, 'A sessao foi encerrada!')
	return redirect('appHome')