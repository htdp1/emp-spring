package com.htdp1.emp.empspring.employee.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.htdp1.emp.empspring.employee.model.Employee;
import com.htdp1.emp.empspring.employee.service.EmployeeService;
import com.htdp1.emp.empspring.rest.service.RestService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1")
@Slf4j
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    RestService<Map<String, Object>> restService;

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

    @GetMapping(value = "/template/employees/{empNo}")
    @ResponseBody
    public Map<String, Object> getEmployee(@PathVariable long empNo) throws Exception {
    	log.debug("getEmployee");
    	
        return getEmployee();
    }

    private Map<String, Object> getEmployee() {
    	log.debug("getEmployee restService");
    	
        return restService.get("http://localhost:8080" + "/v1/employees/10001", HttpHeaders.EMPTY).getBody();
    }
}
