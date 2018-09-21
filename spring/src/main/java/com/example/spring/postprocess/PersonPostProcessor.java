package com.example.spring.postprocess;

import com.example.spring.bean.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;


@Slf4j
public class PersonPostProcessor implements BeanPostProcessor {

    /**
     * 在bean初始化之前调用，初始化操作会覆盖这个地方的操作
     * 初始化设置的age的值会覆盖这个地方设置age的30
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Person) {
            ((Person) bean).setAge(30);
            log.warn("postProcessBeforeInitialization==========设置age：30");
        }

        if ("person".equals(beanName)) {
            log.warn("存在名字为person的bean");
        }
        return bean;
    }

    /**
     * 在bean初始化之后调用，初始化设置的name值会被这个地方设置的name值覆盖
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Person) {
            ((Person) bean).setName("postProcessAfterInitialization");
            log.warn("postProcessBeforeInitialization==========设置name：postProcessAfterInitialization");
        }
        return bean;
    }
}
