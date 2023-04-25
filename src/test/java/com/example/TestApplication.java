package com.example;

import org.apache.commons.lang3.ArrayUtils;

import org.springframework.boot.SpringApplication;

public class TestApplication {
	public static void main(String[] args) {
		SpringApplication.from(DemoSb31Application::main)
				.with(ContainerConfig.class)
				.run(ArrayUtils.add(args, "--spring.docker.compose.enabled=false"));
	}
}
