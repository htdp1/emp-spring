package com.htdp1.empspring.employee.repository;

import com.htdp1.empspring.employee.model.Employee;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
}