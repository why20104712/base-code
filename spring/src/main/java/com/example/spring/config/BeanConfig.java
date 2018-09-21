package com.example.spring.config;

import com.example.spring.bean.Color;
import com.example.spring.bean.Person;
import com.example.spring.beanregister.RedBeanRegister;
import com.example.spring.factorybean.PersonFactoryBean;
import com.example.spring.initializingbean.PersonInitializingBean;
import com.example.spring.postprocess.PersonPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author wanghaiyang
 * @date 2018/9/21 11:27
 */
@Configuration
@Import({Color.class, RedBeanRegister.class})//bean的名称为全类名com.example.spring.bean.Color
public class BeanConfig {

    @Bean(initMethod = "init")
    public Person person() {
        return new Person();
    }


    @Bean
    public PersonPostProcessor personPostProcessor() {
        return new PersonPostProcessor();
    }


    /**
     * 给容器中注册组件；
     * 1）、包扫描+组件标注注解（@Controller/@Service/@Repository/@Component）[自己写的类]
     * 2）、@Bean[导入的第三方包里面的组件]
     * 3）、@Import[快速给容器中导入一个组件]
     * 1）、@Import(要导入到容器中的组件)；容器中就会自动注册这个组件，id默认是全类名
     * 2）、ImportSelector:返回需要导入的组件的全类名数组；
     * 3）、ImportBeanDefinitionRegistrar:手动注册bean到容器中
     * 4）、使用Spring提供的 FactoryBean（工厂Bean）;
     * 1）、默认获取到的是工厂bean调用getObject创建的对象
     * 2）、要获取工厂Bean本身，我们需要给id前面加一个&
     * &colorFactoryBean
     */
    @Bean
    public PersonFactoryBean personFactoryBean() {
//        bean的类型：class com.example.spring.bean.Person
        return new PersonFactoryBean();
    }


    /**
     * bean的生命周期：
     * bean创建---初始化----销毁的过程
     * 容器管理bean的生命周期；
     * 我们可以自定义初始化和销毁方法；容器在bean进行到当前生命周期的时候来调用我们自定义的初始化和销毁方法
     * <p>
     * 构造（对象创建）
     * 单实例：在容器启动的时候创建对象
     * 多实例：在每次获取的时候创建对象\
     * <p>
     * BeanPostProcessor.postProcessBeforeInitialization
     * 初始化：
     * 对象创建完成，并赋值好，调用初始化方法。。。
     * BeanPostProcessor.postProcessAfterInitialization
     * 销毁：
     * 单实例：容器关闭的时候
     * 多实例：容器不会管理这个bean；容器不会调用销毁方法；
     * <p>
     * <p>
     * 遍历得到容器中所有的BeanPostProcessor；挨个执行beforeInitialization，
     * 一但返回null，跳出for循环，不会执行后面的BeanPostProcessor.postProcessorsBeforeInitialization
     * <p>
     * BeanPostProcessor原理
     * populateBean(beanName, mbd, instanceWrapper);给bean进行属性赋值
     * initializeBean
     * {
     * applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);
     * invokeInitMethods(beanName, wrappedBean, mbd);执行自定义初始化
     * applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
     * }
     * <p>
     * <p>
     * <p>
     * 1）、指定初始化和销毁方法；
     * 通过@Bean指定init-method和destroy-method；
     * 2）、通过让Bean实现InitializingBean（定义初始化逻辑），
     * DisposableBean（定义销毁逻辑）;
     * 3）、可以使用JSR250；
     *
     * @PostConstruct：在bean创建完成并且属性赋值完成；来执行初始化方法
     * @PreDestroy：在容器销毁bean之前通知我们进行清理工作 4）、BeanPostProcessor【interface】：bean的后置处理器；
     * 在bean初始化前后进行一些处理工作；
     * postProcessBeforeInitialization:在初始化之前工作
     * postProcessAfterInitialization:在初始化之后工作
     * <p>
     * Spring底层对 BeanPostProcessor 的使用；
     * bean赋值，注入其他组件，@Autowired，生命周期注解功能，@Async,xxx BeanPostProcessor;
     */


    @Bean
    public PersonInitializingBean personInitializingBean() {
        return new PersonInitializingBean();
    }
}
