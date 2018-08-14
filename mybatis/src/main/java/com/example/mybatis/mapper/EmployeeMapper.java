package com.example.mybatis.mapper;

import com.example.mybatis.entity.Employee;
import com.example.mybatis.entity.EmployeeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//@Mapper
public interface EmployeeMapper {

    long countByExample(EmployeeExample example);

    int deleteByExample(EmployeeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Employee record);

    int insertSelective(Employee record);

    List<Employee> selectByExample(EmployeeExample example);

    Employee selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByExample(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
}