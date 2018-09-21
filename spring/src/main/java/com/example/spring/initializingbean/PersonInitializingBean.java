package com.example.spring.initializingbean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

@Slf4j
public class PersonInitializingBean implements InitializingBean, DisposableBean {


    public PersonInitializingBean() {
        log.warn("PersonInitializingBean...constructor...");
    }
    /**
     * 当bean创建完成，设置好属性后会调用该方法
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        log.warn("afterPropertiesSet...");
    }

    /**
     * bean销毁的时候会调用该方法
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        log.warn("destroy...");
    }
}
