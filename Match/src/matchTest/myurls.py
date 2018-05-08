# -*- coding: utf-8 -*-

import urllib2
import cookielib

url = 'http://www.baidu.com'

print 'method1'
#直接请求
response1 = urllib2.urlopen(url)

#获取状态码，200成功
print response1.getcode()

#读取内容
cont = response1.read()

print len(cont)

print 'method2'

request = urllib2.Request(url)
request.add_header("user-agent", "Mozilla/5.0")
response2 = urllib2.urlopen(request)
print response2.getcode()
print len(response2.read())

print 'method3'
cj = cookielib.CookieJar()
opener = urllib2.build_opener(urllib2.HTTPCookieProcessor(cj))
urllib2.install_opener(opener)
response3 = urllib2.urlopen(url)
print response3.getcode()
print cj
#print response3.read()