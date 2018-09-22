package com.example.spring.apsect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * 切面类
 * @Aspect： 告诉Spring当前类是一个切面类
 * @author wanghaiyang
 * @date 2018/9/22 14:26
 */
@Aspect
@Slf4j
public class LogAspect {

    /**
     * 切入点
     * //抽取公共的切入点表达式
     * 	//1、本类引用
     * 	//2、其他的切面引用
     */
    @Pointcut("execution(public * com.example.spring.apsect.MathCalc.*(..))")
    public void pointCut() {

    }

    /**
     * 通知
     */
    @Before(value = "pointCut()")
    public void before(JoinPoint joinPoint) {
        log.warn("前置通知。。。拦截的方法名称{}, 参数列表：{}", joinPoint.getSignature().getName(), joinPoint.getArgs());
    }

    @After(value = "com.example.spring.apsect.LogAspect.pointCut()")
    public void after(JoinPoint joinPoint) {
        log.warn("后置通知。。。拦截的方法名称{}, 参数列表：{}", joinPoint.getSignature().getName(), joinPoint.getArgs());
    }

    /**
     * JoinPoint一定要出现在参数表的第一位，且不能为ProceedingJoinPoint
     */
    @AfterReturning(value = "pointCut()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        log.warn("正常返回通知。。。拦截的方法名称{}, 参数列表：{}, 方法返回值：{}",joinPoint.getSignature().getName(), joinPoint.getArgs(), result);
    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Exception exception) {
        log.warn("异常返回通知。。。拦截的方法名称{}, 参数列表：{}, 异常为：{}",joinPoint.getSignature().getName(), joinPoint.getArgs(), exception.toString());
    }

    /**
     * 环绕通知入参必须使用ProceedingJoinPoint,且只接受一个ProceedingJoinPoint参数
     * 环绕通知与其他通知不可混合使用，使用了环绕通知，政策返回通知和异常返回通知，接收不到返回值和异常信息
     * @param proceedingJoinPoint
     */
    @Around(value = "pointCut()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) {
        log.warn("环绕通知，方法名称：{}，参数列表：{}", proceedingJoinPoint.getSignature().getName(), proceedingJoinPoint.getArgs());
        log.warn("环绕通知-->前置通知。。。");
        try {
            Object proceed = proceedingJoinPoint.proceed();
            log.warn("环绕通知-->后置通知。。。");
            log.warn("环绕通知-->正常返回通知。。。返回结果为：{}", proceed);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            log.warn("环绕通知-->异常返回通知。。。异常为：{}", throwable);
        }

    }


}
