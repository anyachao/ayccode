# -*- coding: utf-8 -*-
from __future__ import unicode_literals
from django.db import models


class Article(models.Model):
    aid = models.CharField(max_length=32,default='Aid')
    title = models.CharField(max_length=32,default='Title')
    pub_time = models.DateTimeField(null=True)
#    content = models.CharField(null=True)

    def __unicode__(self):
        return self.aid