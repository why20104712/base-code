package com.example.mybatisplus.employee.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.mybatisplus.employee.bean.Employee;
import com.example.mybatisplus.employee.mapper.EmployeeMapper;
import com.example.mybatisplus.employee.service.EmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

    @Resource
    private EmployeeMapper employeeMapper;


    @Override
    public Page<Employee> listEmployeePage(Page<Employee> page) {
        //当前页码
        page.setCurrent(1);
        //每页大小
        page.setSize(20);
        Page<Employee> employeePage = page.setRecords(employeeMapper.selectPage(page, new EntityWrapper<Employee>()));
        return employeePage;
    }
}
