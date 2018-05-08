# -*- coding: utf-8 -*-
'''
Created on 2018-5-8

@author: anyac
'''

def mydeco(fn):
        
    def warpper():
        print '之前干什么'
        fn()
        print '之后干什么'
     
    return warpper


@mydeco
def mytest():
    print 'this is test'
    

mytest()