package org.baron.chuck;

import org.springframework.boot.SpringApplication;

public class TestChuckApplication {

	public static void main(String[] args) {
		SpringApplication.from(ChuckApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
