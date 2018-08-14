package com.example.mybatis.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @MapperScan指定dao或者mapper包的位置，可以用 {"",""}的形式指定多个包
 * 或者在mapper上使用mapper注解
 */
@Configuration
@MapperScan("com.example.mybatis.mapper")
public class MybatisConfig {

}
