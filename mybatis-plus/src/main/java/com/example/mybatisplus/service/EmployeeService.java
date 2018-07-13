package com.example.mybatisplus.service;


import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.example.mybatisplus.bean.Employee;

public interface EmployeeService extends IService<Employee> {


    Page<Employee> listEmployeePage(Page<Employee> page);

}
