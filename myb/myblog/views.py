# -*- coding: utf-8 -*-
from __future__ import unicode_literals
from django.shortcuts import render
#from django.http import HttpResponse


#from django.db import models
from . import models
#def index(request):
#    return HttpResponse('Hello,Python!')


def index(request):
    try:
#        article = models.Article.objects.get(pk=1)
        article = models.Article.objects.all()
    except models.Article.DoesNotExist:
        article = None
#    article = models.Article.objects.get(title='hehe')
    return render(request, 'myblog/index.html',{'article': article})
#    return render(request,'myblog/index.html',{'hello':'hello,ayc!!'})


#def index(request):
#    return render(request,'blog/index.html')
def article_page(request,article_id):
    article = models.Article.objects.get(pk=article_id)
    return render(request,'myblog/article_page.html',{'article': article})

def edit_page(request,article_id):
    if str(article_id) == '0':
        return render(request,'myblog/edit_page.html')
    article = models.Article.objects.get(pk=article_id)
    return render(request,'myblog/edit_page.html',{'article': article})

def edit_action(request):
    aid = request.POST.get('aid','AID')
    title = request.POST.get('title','TITLE')
    article_id = request.POST.get('article_id','0')
    
    if article_id == '0':
        models.Article.objects.create(aid=aid,title=title)
        article = models.Article.objects.all()
        return render(request, 'myblog/index.html',{'article': article})
    
    article = models.Article.objects.get(pk=article_id)
    article.aid = aid
    article.title = title
    article.save()
    return render(request,'myblog/article_page.html',{'article': article})
    
    