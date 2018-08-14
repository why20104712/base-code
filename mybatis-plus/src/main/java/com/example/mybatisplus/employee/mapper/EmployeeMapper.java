package com.example.mybatisplus.employee.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.mybatisplus.employee.bean.Employee;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeMapper extends BaseMapper<Employee> {

}
