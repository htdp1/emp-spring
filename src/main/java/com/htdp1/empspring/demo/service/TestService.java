package com.htdp1.empspring.demo.service;

import java.util.List;

import com.htdp1.empspring.demo.mapper.TestMapper;
import com.htdp1.empspring.demo.vo.TestVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    @Autowired
    public TestMapper mapper;

    public TestVo selectEmployeeLimit1(long empNo) {
        return mapper.selectEmployeeLimit1(empNo);
    }

    public List<TestVo> selectEmployees() {
        return mapper.selectEmployees();
    }
}
