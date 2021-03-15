package com.htdp1.empspring.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.htdp1.empspring.employee.model.Employee;
import com.htdp1.empspring.employee.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1")
@Slf4j
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping(value = "/employees/{empNo}")
    @ResponseBody
    public Employee selectEmployee(@PathVariable long empNo) throws Exception {
    	log.debug("selectEmployee");
    	
        return employeeService.selectEmployee(empNo);
    }

    @PostMapping(value = "/employees")
    public int insertEmployee(@RequestBody Employee employee) throws Exception {
    	log.debug("insertEmployee");
    	
        return employeeService.insertEmployee(employee);
    }

}