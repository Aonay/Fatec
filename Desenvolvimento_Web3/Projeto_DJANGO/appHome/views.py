from django.shortcuts import render
from django.http import HttpResponse
from django.template import loader
	
def appHome(request):
	template = loader.get_template("home.html")
	return HttpResponse(template.render())

