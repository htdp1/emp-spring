package com.htdp1.emp.empspring.employee.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table("employees")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Data
public class Employee {

    @Id
    private Long empNo;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String hireDate;
    private String gender;

    @Builder
    @PersistenceConstructor
    public Employee(Long empNo, String firstName, String lastName, String birthDate, String hireDate, String gender) {
        this.empNo = empNo;
        this.firstName = firstName;
    	this.lastName = lastName;
    	this.birthDate = birthDate;
        this.hireDate = hireDate;
        this.gender = gender;
    }

    public Employee(String firstName, String lastName, String birthDate, String hireDate, String gender) {
        this.firstName = firstName;
    	this.lastName = lastName;
    	this.birthDate = birthDate;
        this.hireDate = hireDate;
        this.gender = gender;
    }
}
