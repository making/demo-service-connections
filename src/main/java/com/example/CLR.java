package com.example;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class CLR implements CommandLineRunner {
	private final JdbcTemplate jdbcTemplate;

	public CLR(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void run(String... args) {
		String version = this.jdbcTemplate.queryForObject("SELECT version()", String.class);
		System.out.printf("server version is %s%n", version);
		this.jdbcTemplate.update("INSERT INTO message(text) VALUES (?)", "Hello " + LocalDateTime.now());
		List<Message> messages = this.jdbcTemplate.query("SELECT id, text FROM message", new DataClassRowMapper<>(Message.class));
		messages.forEach(System.out::println);
	}

	public record Message(Integer id, String text) {
	}
}
