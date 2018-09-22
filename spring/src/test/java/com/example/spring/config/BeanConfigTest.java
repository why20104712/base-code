package com.example.spring.config;

import com.example.spring.apsect.MathCalc;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wanghaiyang
 * @date 2018/9/21 11:31
 */
@Slf4j
public class BeanConfigTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);

        log.warn("容器中bean的数量：{}", annotationConfigApplicationContext.getBeanDefinitionCount());

        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        log.warn("======容器中的bean======");
        for (String beanDefinitionName : beanDefinitionNames) {
            log.warn(beanDefinitionName);
        }


        Object person = annotationConfigApplicationContext.getBean("person");
        log.warn("person对象为：{}",person);


        MathCalc mathCalc = (MathCalc) annotationConfigApplicationContext.getBean("mathCalc");
        mathCalc.div(2, 0);

        annotationConfigApplicationContext.close();
    }

    @Test
    public void testImport(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);

        log.warn("容器中bean的数量：{}", annotationConfigApplicationContext.getBeanDefinitionCount());

        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        log.warn("======容器中的bean======");
        for (String beanDefinitionName : beanDefinitionNames) {
            log.warn(beanDefinitionName);
        }
        //工厂Bean获取的是调用getObject创建的对象
        Object bean2 = annotationConfigApplicationContext.getBean("personFactoryBean");
        Object bean3 = annotationConfigApplicationContext.getBean("personFactoryBean");
        log.warn("bean的类型：", bean2.getClass());
        log.warn("是否单例，是否为同一个对象：{}", bean2 == bean3);

        Object bean4 = annotationConfigApplicationContext.getBean("&personFactoryBean");
        log.warn("工厂bean的类型：{}",bean4.getClass());
    }

}