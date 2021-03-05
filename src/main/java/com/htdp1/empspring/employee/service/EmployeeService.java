package com.htdp1.empspring.employee.service;

import com.htdp1.empspring.employee.model.Employee;
import com.htdp1.empspring.employee.repository.EmployeeMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    public EmployeeMapper mapper;

    public Employee selectEmployee(long empNo) {
        return mapper.findById(empNo);
    }

    public int insertEmployee(Employee employee) {
        return mapper.insert(employee);
    }
}
