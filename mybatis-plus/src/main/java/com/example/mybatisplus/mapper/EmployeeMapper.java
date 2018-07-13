package com.example.mybatisplus.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.mybatisplus.bean.Employee;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeMapper extends BaseMapper<Employee> {

}
