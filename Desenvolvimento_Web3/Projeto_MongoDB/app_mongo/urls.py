from django.urls import path
from . import views

urlpatterns = [
    path('cadastrar/', views.cadastrar_usuario, name='cadastrar_usuario'),
    path('sucesso/',views.sucesso, name='sucesso')
]