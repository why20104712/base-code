package com.example.mybatis.mapper;

import com.example.mybatis.entity.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeMapperTest {

    @Resource
    private EmployeeMapper employeeMapper;

    @Test
    public void insertSelective() {
        Employee employee = new Employee();
        employee.setAge(2);
        employee.setEmail("1@qq.com");
        employee.setGender("1");
        employee.setLastName("why");
        employeeMapper.insertSelective(employee);

        System.out.println(employee.getId());
    }

    @Test
    public void insert() {
        Employee employee = new Employee();
        employee.setAge(2);
        employee.setEmail("1@qq.com");
        employee.setGender("1");
        employee.setLastName("why");
        employeeMapper.insert(employee);

        System.out.println(employee.getId());
    }
}