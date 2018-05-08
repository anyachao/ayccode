# -*- coding: utf-8 -*-

'''
Created on 2018-4-20

@author: anyac
'''
import os
import codecs
f = codecs.open('C:\\Users\\anyac\\Desktop\\2.txt','a+','utf-8')   #创建utf-8编码格式的文件

a = unicode.encode(u'哈哈哈','utf-8')

print a

f.write(a)

f.flush()

print f.read(4)

#f.seek(-2,os.SEEK_CUR)

#print f.tell()

f.close()

