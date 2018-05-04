from django.shortcuts import render

def index(request):
    return render(request,'myblog3/index.html',{'hello':'hello,ayc222!!'})
# Create your views here.
