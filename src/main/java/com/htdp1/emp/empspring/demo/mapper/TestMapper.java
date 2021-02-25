package com.htdp1.emp.empspring.demo.mapper;

import java.util.List;

import com.htdp1.emp.empspring.demo.vo.TestVo;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper {

    TestVo selectEmployeeLimit1(long empNo);

    List<TestVo> selectEmployees();
}