package com.htdp1.empspring.employee.config;

import com.htdp1.empspring.employee.model.Employee;
import com.htdp1.empspring.employee.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.relational.core.mapping.event.BeforeSaveEvent;

@Configuration
public class EmployeeConfig {
    @Autowired
	EmployeeRepository employeeRepository;

	@Bean
	@SuppressWarnings("rawtypes")
	public ApplicationListener<BeforeSaveEvent> idSetting() {
	
		return event -> {
	
			if (event.getEntity() instanceof Employee) {

				Employee employee = (Employee) event.getEntity();
				if (employee.getEmpNo() == null) {
					employee.setEmpNo(employeeRepository.count() + 200000L);
				}
			}
		};
	}
}
