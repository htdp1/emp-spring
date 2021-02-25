package com.htdp1.emp.empspring.demo.controller;

import java.util.List;

import com.htdp1.emp.empspring.demo.service.TestService;
import com.htdp1.emp.empspring.demo.vo.TestVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping(value = "/test/{empNo}")
    @ResponseBody
    public TestVo test(@PathVariable long empNo) throws Exception {
            return testService.selectEmployeeLimit1(empNo);
    }

    @GetMapping(value = "/test")
    @ResponseBody
    public List<TestVo> test() throws Exception {
            return testService.selectEmployees();
    }
}
