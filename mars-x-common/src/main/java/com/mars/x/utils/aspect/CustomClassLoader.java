package com.mars.x.utils.aspect;

import javassist.*;

/**
 * @author: sj.hu
 * @date: 2020/4/15 17:21
 **/
public class CustomClassLoader{
    public static void main(String[] args) throws Throwable {
        // 3、自定义类加载器实现AOP。
        // 原理：字节码加载前直接修改需要切入的方法。
        // 使用技术：字节码编辑框架Javassist

        //获取存放CtClass的容器ClassPool
        ClassPool cp = ClassPool.getDefault();
        //创建一个类加载器
        Loader cl = new Loader();
        //增加一个转换器
        cl.addTranslator(cp, new MyTranslator());
        //启动MyTranslator的main函数
        cl.run("com.mars.x.utils.aspect.CustomClassLoader$MyTranslator", args);
    }

    public static class MyTranslator implements Translator {

        public static void main(String[] args) {
            DynamicProxyDemo.Business business = new DynamicProxyDemo.Business();
            business.doSomeThing2();
            business.doSomeThing();
        }

        @Override
        public void start(ClassPool classPool) throws NotFoundException, CannotCompileException {

        }

        @Override
        public void onLoad(ClassPool classPool, String className) throws NotFoundException, CannotCompileException {
            if(!"com.mars.x.utils.aspect.DynamicProxyDemo$Business".equalsIgnoreCase(className)) {
                return;
            }
            try {
                CtClass ctClass = classPool.get(className);
                // 获取指定方法名的方法
                CtMethod ctMethod = ctClass.getDeclaredMethod("doSomeThing");
                // 在方法执行前插入代码
                ctMethod.insertBefore("{ System.out.println(\"Record Log\");}");
            } catch (Throwable th) {

            }
        }
    }
}
