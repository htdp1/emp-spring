package com.htdp1.empspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.jdbc.repository.config.MyBatisJdbcConfiguration;

@SpringBootApplication
@Configuration
@EnableJdbcRepositories
@Import(MyBatisJdbcConfiguration.class)
public class EmpSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpSpringApplication.class, args);
	}

}
