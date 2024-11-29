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
    path('excluirUsuario/<int:id_usuario>', views.excluirUsuario, name='excluir_usuario'),
    path('editarUsuario/<int:id_usuario>', views.editarUsuario, name='editar_usuario'),
    path('excluirProjeto/<int:id_projeto>', views.excluirProjeto, name='excluir_projeto'),
    path('editarProjeto/<int:id_projeto>', views.editarProjeto, name='editar_projeto'),
    path('redefinir-senha/', views.redefinir_senha, name='redefinir_senha'),
    path('apagar-conta/', views.apagarConta, name='apagar_conta'),
    path('subir-foto/', views.criar_foto, name='criar_foto'),
    path('galeria/', views.ver_galeria, name='galeria'),
    path('contato/', views.contato, name='contato'),

    
]