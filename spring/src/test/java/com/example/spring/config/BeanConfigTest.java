package com.example.spring.config;

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
        System.out.println(person);


    }
}