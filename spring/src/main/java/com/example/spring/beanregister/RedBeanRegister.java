package com.example.spring.beanregister;

import com.example.spring.bean.Red;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author wanghaiyang
 * @date 2018/9/21 22:35
 */
public class RedBeanRegister implements ImportBeanDefinitionRegistrar {

    /**
     * 手动注册bean
     * @param importingClassMetadata 当前类的注解信息
     * @param registry bean的定义信息的注册表
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        registry.registerBeanDefinition("red", new RootBeanDefinition(Red.class));
    }
}
