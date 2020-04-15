package com.mars.x.utils.aspect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: sj.hu
 * @date: 2020/4/15 15:35
 **/
public class DynamicProxyDemo {


    public static void main(String[] args) {
        // 1、动态代理实现AOP
        // 原理：

        // 需要的代理类接口
        Class[] proxyInterface = new Class[] {IBusiness.class, IBusiness2.class};
        // 构建AOP的Advice，需要传入业务类实例
        LogInvocationHandler handler = new LogInvocationHandler(new Business());

        //生成代理类字节码加载器
        ClassLoader classLoader = DynamicProxyDemo.class.getClassLoader();

        // 织入器，织入代码并生成代理类
        IBusiness2 proxyBusiness = (IBusiness2) Proxy.newProxyInstance(classLoader, proxyInterface, handler);
        proxyBusiness.doSomeThing2();
        ((IBusiness)proxyBusiness).doSomeThing();
    }

    static class LogInvocationHandler implements InvocationHandler {

        private Object target;

        public LogInvocationHandler(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Object rev = method.invoke(target, args);

            if(method.getName().equalsIgnoreCase("doSomeThing2")) {
                System.out.println("Record Log");
            }

            return rev;
        }
    }

    static class Business implements IBusiness, IBusiness2 {

        @Override
        public boolean doSomeThing() {
            System.out.println("Do Some Thing");
            return true;
        }

        @Override
        public void doSomeThing2() {
            System.out.println("Do Some Thing 2");
        }
    }

    interface IBusiness {
        boolean doSomeThing();
    }

    interface IBusiness2{
        void doSomeThing2();
    }

}
