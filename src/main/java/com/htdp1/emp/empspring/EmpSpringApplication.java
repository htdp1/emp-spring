package com.htdp1.emp.empspring;

import javax.sql.DataSource;

import com.htdp1.emp.empspring.employee.model.Employee;
import com.htdp1.emp.empspring.employee.repository.EmployeeRepository;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.jdbc.repository.config.MyBatisJdbcConfiguration;
import org.springframework.data.relational.core.mapping.event.BeforeSaveEvent;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@Configuration
@EnableJdbcRepositories
@Import(MyBatisJdbcConfiguration.class)
public class EmpSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpSpringApplication.class, args);
	}

	@Bean 
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Autowired
	private DataSource dataSource;

	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception{
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		
		Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/**/*.xml");
		sessionFactory.setMapperLocations(res);

		Resource myBatisConfig = new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config.xml");
		sessionFactory.setConfigLocation(myBatisConfig);
		
		return sessionFactory.getObject();
	}

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
