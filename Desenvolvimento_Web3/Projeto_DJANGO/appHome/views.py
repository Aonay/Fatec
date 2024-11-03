from datetime import timedelta
from django.shortcuts import render, redirect
from .forms import UsuarioForm,ProjetoForm, FormLogin,RedefinirSenhaForm
from .models import Usuario,Projeto
from django.contrib import messages
from django.contrib.auth.hashers import make_password,check_password
from django.contrib.auth import logout


	
def appHome(request):
	email = request.session.get('email')
	context = {
		'username':email,
		'messages': messages.get_messages(request),
		'exibir_mensagens':True
		
	}
	return render(request,'home.html',context)


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
	email = request.session.get('email')
	usuarios = Usuario.objects.all().values()
	context = {
		'username':email,
		'usuarios':usuarios
	}
	return render(request,'lista_usuarios.html',context)


def criar_projeto(request):
	email = request.session.get('email')
	if request.method == 'POST':
		form = ProjetoForm(request.POST or None)
		if form.is_valid():
			form.save()
			messages.success(request, "Projeto cadastrado com sucesso!")
			return redirect('appHome')
	else:
		form = ProjetoForm()

	context ={
		'form':form,
		'username':email
	}
	return render(request,'criar_projeto.html',context)


def lista_projetos(request):
	email = request.session.get('email')
	projetos = Projeto.objects.all().values()

	context ={
		'projetos':projetos,
		'username':email
	}

	return render(request,'lista_projetos.html',context)


def form_login(request):
	formLogin = FormLogin(request.POST or None)
	
	if request.POST:
		_email = request.POST['email']
		_senha = request.POST['senha']


		try:
			usuario = Usuario.objects.get(email=_email)

			if check_password(_senha,usuario.senha):
				#sessao
				request.session.set_expiry(timedelta(minutes=30))
				#variaveis de sesao
				request.session['email'] = _email
				request.session['nome'] = usuario.nome
				
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
		messages.info(request,'A sessao expirou')
		return redirect('appHome')
	
	email = request.session.get('email')
	nome = request.session.get('nome')

	context = {
		'username':email,
		'nome':nome
	}
	return render(request,'dashboard.html',context)


def userLogout(request):
	logout(request)
	messages.success(request, 'A sessao foi encerrada!')
	return redirect('appHome')

def excluirUsuario(request, id_usuario):
	usuario = Usuario.objects.get(id=id_usuario)
	usuario.delete()
	return redirect('lista_usuarios')

def editarUsuario(request, id_usuario):
	usuario = Usuario.objects.get(id=id_usuario)
	form = UsuarioForm(request.POST or None, instance=usuario)
	if request.POST:
		if form.is_valid():
			user = form.save(commit=False)
			user.senha = make_password(form.cleaned_data['senha'])
			user.save()
			messages.success(request, "Usuario cadastrado com sucesso!")
			return redirect('appHome')
	context = {
		'form':form
	}
	return render(request,'editar_usuario.html', context)

def redefinir_senha(request):
	if 'email' not in request.session:
		messages.info(request,'Voce precisa estar logado para alterar sua senha')
		return redirect('form_login')
	
	_email = request.session.get('email')
	usuario = Usuario.objects.get(email=_email)
	
	if request.method == 'POST':
		form = RedefinirSenhaForm(request.POST or None)
		

		if form.is_valid():
			senha_atual = form.cleaned_data['senha_atual']
			nova_senha = form.cleaned_data['nova_senha']
			confirmacao_senha = form.cleaned_data['confirmacao_senha']


			# Verifica se a senha atual está correta
			if not check_password(senha_atual, usuario.senha):  # Altere 'request.user.senha' conforme necessário
					messages.error(request, 'A senha atual está incorreta.')
					return render(request, 'redefinir_senha.html', {'form': form, 'username': _email})

			# Verifica se a nova senha e a confirmação são iguais
			if nova_senha != confirmacao_senha:
					messages.error(request, 'As novas senhas não coincidem.')
					return render(request, 'redefinir_senha.html', {'form': form, 'username': _email})

			# Atualiza a senha do usuário
			usuario.senha = make_password(nova_senha)
			usuario.save()
			messages.success(request, 'Sua senha foi alterada com sucesso.')
			return redirect('form_login')  # Redirecione para onde quiser

	else:
		form = RedefinirSenhaForm()

	return render(request, 'redefinir_senha.html', {'form': form, 'username': _email})

				



		


