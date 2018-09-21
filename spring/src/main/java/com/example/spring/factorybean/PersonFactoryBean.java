package com.example.spring.factorybean;

import com.example.spring.bean.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.FactoryBean;

/**
 * 使用FactoryBean注入bean
 * @author wanghaiyang
 * @date 2018/9/21 15:32
 */
@Slf4j
public class PersonFactoryBean implements FactoryBean<Person> {

    /**
     * 返回一个Person对象，这个对象会添加到容器中
     * @return
     * @throws Exception
     */
    @Override
    public Person getObject() throws Exception {
        log.warn("PersonFactoryBean=====getObject()====");
        return new Person();
    }

    @Override
    public Class<?> getObjectType() {
        return Person.class;
    }

    //是单例？
    //true：这个bean是单实例，在容器中保存一份
    //false：多实例，每次获取都会创建一个新的bean；
    @Override
    public boolean isSingleton() {
        return false;
    }
}
