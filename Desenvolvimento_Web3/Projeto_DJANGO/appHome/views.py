from datetime import timedelta
from django.shortcuts import render, redirect
from .forms import UsuarioForm,ProjetoForm, FormLogin,RedefinirSenhaForm, FotoForm,UsuarioEditForm,ContatoForm
from .models import Usuario,Projeto,Foto,Vendas
from django.contrib import messages
from django.contrib.auth.hashers import make_password,check_password
from django.contrib.auth import logout
from django.utils.timezone import now
import io
import urllib, base64
import matplotlib.pyplot as plt
from django.db.models import Sum
from django.db.models.functions import TruncMonth
from datetime import datetime
import textwrap
import calendar
import locale
from dateutil.relativedelta import relativedelta


	
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
		form = UsuarioForm(request.POST or None,request.FILES)
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
	projetos = Projeto.objects.all().values()
	context = {
		'username':email,
		'usuarios':usuarios,
		'projetos':projetos,
		'messages': messages.get_messages(request),
		'exibir_mensagens':True
	}
	return render(request,'lista_usuarios.html',context)

def criar_projeto(request):
	email = request.session.get('email')
	if request.method == 'POST':
		form = ProjetoForm(request.POST or None,request.FILES)
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
				request.session['id']= usuario.id
				
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
	id = request.session.get('id')

	usuario = Usuario.objects.get(id=id)
	imagem = usuario.foto
	context = {
		'imagem':imagem,
		'username':email,
		'nome':nome,
		'id':id
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
	form = UsuarioEditForm(request.POST or None, instance=usuario)
	if request.POST:
		if form.is_valid():
			user = form.save(commit=False)
			user.senha = make_password(form.cleaned_data['senha'])
			user.save()
			messages.success(request, "Usuario editado com sucesso!")
			return redirect('lista_usuarios')
	context = {
		'form':form
	}
	return render(request,'editar_usuario.html', context)

def excluirProjeto(request, id_projeto):
	projeto = Projeto.objects.get(id=id_projeto)
	projeto.delete()
	return redirect('lista_usuarios')

def editarProjeto(request, id_projeto):
	projeto = Projeto.objects.get(id=id_projeto)
	form = ProjetoForm(request.POST or None, instance=projeto)
	if request.POST:
		if form.is_valid():
			form.save()
			messages.success(request, "Projeto Atualizado com sucesso!")
			return redirect('lista_usuarios')
	context = {
		'form':form
	}
	return render(request,'editar_projeto.html', context)

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


		
			if not check_password(senha_atual, usuario.senha):
					messages.error(request, 'A senha atual está incorreta.')
					return render(request, 'redefinir_senha.html', {'form': form, 'username': _email})

		
			if nova_senha != confirmacao_senha:
					messages.error(request, 'As novas senhas não coincidem.')
					return render(request, 'redefinir_senha.html', {'form': form, 'username': _email})

		
			usuario.senha = make_password(nova_senha)
			usuario.save()
			messages.success(request, 'Sua senha foi alterada com sucesso.')
			return redirect('form_login')
	else:
		form = RedefinirSenhaForm()

	return render(request, 'redefinir_senha.html', {'form': form, 'username': _email})

def apagarConta(request):
	id_usuario = request.session.get('id')
	if id_usuario:
		try:
			usuario = Usuario.objects.get(id=id_usuario)
			usuario.delete()
			logout(request)
			messages.success(request,"Sua conta foi apagada com sucesso!")
			return redirect('appHome')
		except Usuario.DoesNotExist:
			messages.error(request, "Usuario nao econtrado!")

	else:
		messages.error(request, "Voce precisa estar logado pra excluir sua conta!")

	return redirect('appHome')

def criar_foto(request):
	if request.method == 'POST':
		form = FotoForm(request.POST, request.FILES)
		if form.is_valid():
			form.save()
			return redirect('galeria')
	else:
		form = FotoForm()
	return render(request,'criar_foto.html',{'form':form})

def ver_galeria(request):
	email = request.session.get('email')
	imagens = Foto.objects.all().values()
	fotos = Usuario.objects.all().values()
	capas = Projeto.objects.all().values()

	context ={
		'imagens':imagens,
		'fotos':fotos,
		'capas':capas,
		'username':email
	}

	return render(request,'galeria.html',context)

def contato(request):
	email = request.session.get('email')
	if request.method == 'POST':
		form = ContatoForm(request.POST or None)
		if form.is_valid():
			form.save()
			messages.success(request, "Sua mensagem foi enviada, retornarermos no email fornecido assim que possivel")
			return redirect('appHome')
	else:
		form = ContatoForm()

	context ={
		'form':form,
		'username':email
	}
	return render(request,'contato.html',context)

def confirmarCompra(request,id_projeto):
	if 'email' not in request.session:
		messages.info(request,'E necessario estar logado')
		return redirect('form_login')
	
	curso = Projeto.objects.get(id=id_projeto)
	 
	context = {
		'curso': curso,
		'id_projeto':curso.id
	}
	return render(request, 'confirmar_compra.html',context)

def finalizarCompra(request):
	if 'email' not in request.session:
		messages.info(request,'E necessario estar logado para comprar')
		return redirect('form_login')
	if request.method == 'POST':
		id_usuario = request.session.get('id')
		id_projeto = request.POST.get('id_projeto')
		curso = Projeto.objects.get(id=id_projeto)

		if curso.vagas <= 0:
			messages.error(request, 'Não há mais vagas disponíveis para este curso.')
			return redirect('lista_projetos')
		
		curso.vagas -= 1  
		curso.save() 
		
		hoje = datetime.now().date()
		mes_anterior = hoje - relativedelta(months=1)
		mes_posterior = hoje + relativedelta(months=1) 

		venda = Vendas(
			idUsuario = id_usuario,
			idCurso = id_projeto,
			curso = curso.nome,
			valorPago = curso.valor,
			dtCompra= mes_posterior
		)
		venda.save()
		messages.success(request,'Compra realizada com sucesso!')
		return redirect('lista_projetos')
	
	return redirect('lista_projetos')

def grafico(request):
	# Configurar o locale para Português do Brasil
	locale.setlocale(locale.LC_TIME, 'pt_BR.UTF-8')

	# 1. Dados gerais: vendas totais por curso
	vendas_totais = Vendas.objects.values('curso').annotate(valor_total=Sum('valorPago'))
	cursos = [venda['curso'] for venda in vendas_totais]
	precos = [venda['valor_total'] for venda in vendas_totais]

	# Ajuste de texto para cursos com nomes longos
	cursos = [textwrap.fill(curso, width=15) for curso in cursos]

	# Criar o gráfico geral
	fig1, xy1 = plt.subplots()
	xy1.bar(cursos, precos, color='skyblue')
	xy1.set_xlabel('Cursos')
	xy1.set_ylabel('Valor Total')
	xy1.set_title('Vendas Totais por Curso')
	xy1.tick_params(axis='x', rotation=45)  # Girar os rótulos do eixo X
	plt.tight_layout()  # Garante que os rótulos não sejam cortados

	# Salvar o gráfico em memória
	buf1 = io.BytesIO()
	plt.savefig(buf1, format='png')
	buf1.seek(0)
	string1 = base64.b64encode(buf1.read()).decode('utf-8')
	grafico_geral = 'data:image/png;base64,' + string1

	# 2. Dados detalhados: vendas mensais
	vendas_mensais = (
			Vendas.objects.annotate(mes=TruncMonth('dtCompra'))
			.values('mes', 'curso')
			.annotate(valor_total=Sum('valorPago'))
			.order_by('mes')
	)

	# Preparar os dados para o gráfico
	meses = sorted(list(set(venda['mes'].month for venda in vendas_mensais)))
	nomes_meses = [calendar.month_name[mes].capitalize() for mes in meses]  # Nome do mês em português com a primeira letra maiúscula
	cursos_set = set(venda['curso'] for venda in vendas_mensais)
	data_por_curso = {curso: [0] * len(meses) for curso in cursos_set}

	for venda in vendas_mensais:
			curso = venda['curso']
			mes = venda['mes'].month
			valor = venda['valor_total']
			mes_idx = meses.index(mes)
			data_por_curso[curso][mes_idx] = valor

	# Criar o gráfico individual por mês
	fig2, xy2 = plt.subplots()
	for curso, valores in data_por_curso.items():
			xy2.plot(nomes_meses, valores, marker='o', label=curso)

	xy2.set_xlabel('Meses')
	xy2.set_ylabel('Valor Total')
	xy2.set_title('Vendas Mensais por Curso')
	xy2.legend()
	xy2.grid()

	# Salvar o gráfico em memória
	buf2 = io.BytesIO()
	plt.savefig(buf2, format='png')
	buf2.seek(0)
	string2 = base64.b64encode(buf2.read()).decode('utf-8')
	grafico_individual = 'data:image/png;base64,' + string2

	# Contexto para renderização
	context = {
			'grafico_geral': grafico_geral,
			'grafico_individual': grafico_individual,
	}

	return render(request, 'grafico.html', context)


				



		


