from django.urls import path
from . import views

urlpatterns = [
		path('' , views.appHome, name="appHome"),
    path('criar/',views.criar_usuario,name='criar_usuario'),
    path('usuarios/',views.lista_usuarios, name='lista_usuarios'),
    path('novoProjeto/',views.criar_projeto, name='criar_projeto'),
    path('projetos/', views.lista_projetos, name='lista_projetos'),
    path('login/', views.form_login, name='form_login'),
    path('dashboard/',views.dashboard, name='dashboard'),
    path('logout/', views.userLogout, name='userLogout'),
    path('excluir/<int:id_usuario>', views.excluirUsuario, name='excluir_usuario'),
    path('editar/<int:id_usuario>', views.editarUsuario, name='editar_usuario'),
    path('redefinir-senha/', views.redefinir_senha, name='redefinir_senha'),
    path('apagar-conta/', views.apagarConta, name='apagar_conta'),
    
]