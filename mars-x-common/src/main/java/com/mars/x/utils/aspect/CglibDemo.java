package com.mars.x.utils.aspect;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author: sj.hu
 * @date: 2020/4/15 17:04
 **/
public class CglibDemo {
    public static void main(String[] args) {
        // 2、动态字节码生成实现AOP
        // 原理：在运行期间目标字节码加载后，生成目标类的子类，将切面逻辑加入到子类中
        // 所以使用Cglib实现AOP不需要基于接口
        byteCodeGe();
    }

    static void byteCodeGe() {
        // 创建织入器
        Enhancer enhancer = new Enhancer();
        // 设置父类
        enhancer.setSuperclass(DynamicProxyDemo.Business.class);
        // 设置需要织入的逻辑
        enhancer.setCallback(new LogIntercept());
        // 使用织入器创建子类
        DynamicProxyDemo.IBusiness2 newBussiness = (DynamicProxyDemo.IBusiness2) enhancer.create();
        newBussiness.doSomeThing2();
    }

    static class LogIntercept implements MethodInterceptor {
        @Override
        public Object intercept(Object target, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
            Object rev = methodProxy.invokeSuper(target, args);

            //执行织入日志
            if(method.getName().equalsIgnoreCase("doSomeThing2")) {
                System.out.println("Record Log");
            }
            return rev;
        }
    }
}
