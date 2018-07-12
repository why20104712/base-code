package com.example.dynamicproxy.cglib;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;

public class CglibRun {


//    代理对象的生成过程由Enhancer类实现，大概步骤如下：
//    1、生成代理类Class的二进制字节码；
//    2、通过Class.forName加载二进制字节码，生成Class对象；
//    3、通过反射机制获取实例构造，并初始化代理类对象
    public static void main(String[] args) {
//        cglib字节码生成
//        Enhancer是CGLib的字节码增强器，可以方便的对类进行扩展，内部调用GeneratorStrategy.generate方法生成代理类的字节码，通过以下方式可以生成class文件
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/why/IdeaProjects/86links/base-code/dynamic-proxy/target");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserServiceImpl.class);
        enhancer.setCallback(new MyMethodInterceptor());
        UserServiceImpl userService = (UserServiceImpl) enhancer.create();
        userService.add();

    }


}
