package com.example.mybatisplus.employee.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.example.mybatisplus.employee.bean.Employee;
import com.example.mybatisplus.employee.mapper.EmployeeMapper;
import com.example.mybatisplus.employee.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class EmployeeController {


    @Resource
    private EmployeeMapper employeeMapper;

    @Resource
    private EmployeeService employeeService;


    /**
     * 获取详情
     * @param id
     * @return
     */
    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable Integer id) {
        return employeeMapper.selectById(id);
    }


    /**
     * 分页查询
     * @return
     */
    @GetMapping("/employee/page")
    public Page<Employee> listEmployeePage() {
        return employeeService.listEmployeePage(new com.baomidou.mybatisplus.plugins.Page<Employee>());
    }


    /**
     * 新增
     * @param employee
     * @return
     */
    @PostMapping("/employee")
    public Integer insertEmployee(@RequestBody Employee employee) {
        boolean flag = employeeService.insert(employee);
        if (flag) {
            return employee.getId();
        }
        return 0;
    }

    /**
     * 修改
     * @param employee
     * @return
     */
    @PutMapping("/employee")
    public Integer updateEmployee(@RequestBody Employee employee) {
        boolean flag = employeeService.updateById(employee);
        if (flag) {
            return employee.getId();
        }
        return 0;
    }


    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping("/employee/{id}")
    public Boolean deleteEmployee(@PathVariable Integer id) {
        return employeeService.deleteById(id);
    }

}
