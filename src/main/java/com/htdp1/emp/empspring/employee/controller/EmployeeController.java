package com.htdp1.emp.empspring.employee.controller;

import com.htdp1.emp.empspring.employee.model.Employee;
import com.htdp1.emp.empspring.employee.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping(value = "/employees/{empNo}")
    @ResponseBody
    public Employee selectEmployee(@PathVariable long empNo) throws Exception {
            return employeeService.selectEmployee(empNo);
    }
}
