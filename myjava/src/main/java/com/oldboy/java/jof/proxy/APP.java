package com.oldboy.java.jof.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class APP {
    public static void main(String[] args) {
        //目标对象
        final WelcomeService2 target = new WelcomeServiceImpl();


        //类加载器
        ClassLoader loader = ClassLoader.getSystemClassLoader();

        //接口集合
        Class[] interfaces = {WelcomeService.class,WelcomeService2.class};

        //处理器
        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                long start = System.nanoTime();
                Object ret = method.invoke(target, args);
                long dur = System.nanoTime() - start;
                System.out.println(method.getName() + "耗时" + dur);
                return ret;
            }
        };
        //创建代理对象
        WelcomeService proxy = (WelcomeService) Proxy.newProxyInstance(loader,interfaces,h);
        //访问代理对象的方法
        proxy.sayHello("tomas");
        ((WelcomeService2)proxy).sayHello2("tomas2");
    }
}
