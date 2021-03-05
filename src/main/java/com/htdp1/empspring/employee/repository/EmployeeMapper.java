package com.htdp1.empspring.employee.repository;

import com.htdp1.empspring.employee.model.Employee;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper {

    Employee findById(long empNo);
    int insert(Employee employee);
}