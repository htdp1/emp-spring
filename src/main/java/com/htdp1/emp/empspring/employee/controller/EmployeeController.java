package com.htdp1.emp.empspring.employee.controller;

import java.util.Map;

import com.htdp1.emp.empspring.employee.model.Employee;
import com.htdp1.emp.empspring.employee.service.EmployeeService;
import com.htdp1.emp.empspring.rest.service.RestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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

    @Autowired
    RestService<Map<String, Object>> restService;

    @GetMapping(value = "/employees/{empNo}")
    @ResponseBody
    public Employee selectEmployee(@PathVariable long empNo) throws Exception {
        return employeeService.selectEmployee(empNo);
    }

    @GetMapping(value = "/template/employees/{empNo}")
    @ResponseBody
    public Map<String, Object> getEmployee(@PathVariable long empNo) throws Exception {
        return getEmployee();
    }

    private Map<String, Object> getEmployee() {
        return restService.get("http://localhost:8080" + "/v1/employees/10001", HttpHeaders.EMPTY).getBody();
    }
}
