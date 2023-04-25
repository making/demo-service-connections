package com.example;

import org.testcontainers.containers.PostgreSQLContainer;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;

@TestConfiguration(proxyBeanMethods = false)
public class ContainerConfig {
	@Bean
	@ServiceConnection
	public PostgreSQLContainer<?> postgreSqlContainer() {
		return new PostgreSQLContainer<>("postgres:14-alpine");
	}
}
