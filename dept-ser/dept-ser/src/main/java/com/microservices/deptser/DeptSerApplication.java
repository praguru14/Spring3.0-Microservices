package com.microservices.deptser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = "com.microservices.deptser.controller.DepartmentController")
public class DeptSerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeptSerApplication.class, args);
	}

}
