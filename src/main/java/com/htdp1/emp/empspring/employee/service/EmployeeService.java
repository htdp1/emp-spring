package com.htdp1.emp.empspring.employee.service;

import com.htdp1.emp.empspring.employee.model.Employee;
import com.htdp1.emp.empspring.employee.repository.EmployeeMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    public EmployeeMapper mapper;

    public Employee selectEmployee(long empNo) {
        return mapper.findById(empNo);
    }
}
