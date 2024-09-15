from django.urls import path
from . import views

urlpatterns = [
    path('', views.home, name="home"),#para a pagina ser a home é só deixar o primeiro paramento vazio
]