package com.example.mybatisplus.employee.service;


import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.example.mybatisplus.employee.bean.Employee;

public interface EmployeeService extends IService<Employee> {


    Page<Employee> listEmployeePage(Page<Employee> page);

}
