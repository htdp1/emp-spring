package com.htdp1.emp.empspring.demo.service;

import com.htdp1.emp.empspring.demo.mapper.TestMapper;
import com.htdp1.emp.empspring.demo.vo.TestVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    @Autowired
    public TestMapper mapper;

    public TestVo selectEmployeeLimit1(long empNo) {
        return mapper.selectEmployeeLimit1(empNo);
    }
}
