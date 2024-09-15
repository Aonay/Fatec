from django.shortcuts import render
from django.http import HttpResponse

from django.template import loader

# Create your views here.
# aqui ficam as funcoes que levam as paginas semelhante ao controller em MVC

def home(request):
    template = loader.get_template("home.html")
    return HttpResponse(template.render())

