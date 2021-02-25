package com.htdp1.emp.empspring.employee.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table("employees")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Data
public class Employee {

    @Id
    private Long empNo;

    private String firstName;

    private String lastName;

    private String birthDate;

    private String hireDate;

    private String gender;
}
