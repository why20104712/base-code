package com.example.spring.config;

import com.example.spring.bean.Person;
import com.example.spring.postprocess.PersonPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wanghaiyang
 * @date 2018/9/21 11:27
 */
@Configuration
public class BeanConfig {

    @Bean(initMethod = "init")
    public Person person() {
        return new Person();
    }


    @Bean
    public PersonPostProcessor personPostProcessor() {
        return new PersonPostProcessor();
    }

}
