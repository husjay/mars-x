package com.mars.x.aspect;

import com.mars.x.annotation.XRetryable;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class XRetryableAspect {

    @Pointcut("@annotation(com.mars.x.annotation.XRetryable)")
    private void pointcut() {}

    @Around("pointcut() && @annotation(xRetryable)")
    public Object advice(ProceedingJoinPoint joinPoint, XRetryable xRetryable) {
        System.out.println("Class:" + joinPoint.getSignature().getDeclaringType().getSimpleName()
                +"method:"+joinPoint.getSignature().getName());

        Object result = null;

        try {
            result = joinPoint.proceed();
        } catch (Throwable th) {

        }

        return result;
    }

}
