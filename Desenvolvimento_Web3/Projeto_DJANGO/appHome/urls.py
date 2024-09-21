from django.urls import path
from . import views

urlpatterns = [
		path('' , views.appHome, name="appHome"),
    path('criar/',views.criar_usuario,name='criar_usuario'),
    path('usuarios/',views.lista_usuarios, name='lista_usuarios'),
]