# -*- coding: utf-8 -*-
'''
Created on 2018-4-10

@author: anyac
'''
import re

str1 = 'aYc haha=1000'
pa = re.compile(r'ayc',re.I)    #忽略大小写
ma = pa.match(str1)

str2 = 'ayc=100,lmy=90,aycailmy=999'

pa1 = re.compile(r'(ayc)',re.I)   #返回元组tuple
ma1 = pa1.match(str1)

ma2 = re.match(r'(ayc)','ayc haha') #直接匹配

ma3 = re.match(r'.','bab')  #匹配任意字符

ma4 = re.match(r'[a-zA-Z]','sd')

ma5 = re.match(r'\[[\w]\]','[q]')   #\转义字符，匹配中括号

ma6 = re.match(r'[A-Z][a-z]*','Sdasd')   #*0次或无限次

ma7 = re.match(r'[a-zA-Z0-9]{6,9}','123sddjk')   #匹配6-9次

ma8 = re.match(r'[0-9][a-z]*?','1sddjk')   #尽量少匹配

ma9 = re.match(r'\Aayc[\w]*','aycsdjk')   #\A以ayc开头

ma10 = re.match(r'ayc|lmy','lmy')   #匹配任意一个

ma11 = re.match(r'[\w]{4,6}@(163|126).com','asdss@163.com')   #分组或匹配

ma12 = re.match(r'<([\w]+>)[\w]+</\1','<Book>Python</Book>')   #\1代表括号里的内容 Book>

ma13 = re.match(r'<(?P<mark>[\w]+>)[\w]+</(?P=mark)','<Book>Python</Book>')   # ?P<mark>是分组别名，相当于上面的\1

ma14 = re.search(r'\d+',str1)   #查找带有数字的

ma15 = re.findall(r'\d+',str2)   #查找所有带有数字的，得到list

def add1(match):
    num = match.group()
    numres = int(num) + 1
    return str(numres)
ma16 = re.sub(r'\d+', add1, str2)   #替换str2中所有数字为234 '234'处可以为函数

str3 = 'ayc:lmy lmy1 lmy2'
ma17 = re.split(r':| ',str3)   #分割

print ma.group()   #a
print ma.span()    #(0,1)
print ma.string    #aYc haha=1000

print ma1.groups()   #返回元组tuple （'aYc',）
print ma2.group()   #ayc
print ma3.group()   #b
print ma4.group()   #s
print ma5.group()   #[q]
print ma6.group()   #Sdasd
print ma7.group()   #123sddjk
print ma8.group()   #1
print ma9.group()   #aycsdjk
print ma10.group()   #lmy
print ma11.group()   #asdss@163.com
print ma12.group()   #<Book>Python</Book>
print ma13.group()   #<Book>Python</Book>
print ma14.group()   #1000
print ma15           #['100', '90', '999']
print ma16           #ayc=101,lmy=91,aycailmy=1000
print ma17           #['ayc', 'lmy', 'lmy1', 'lmy2']



