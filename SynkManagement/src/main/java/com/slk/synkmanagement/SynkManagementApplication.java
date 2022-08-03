package com.slk.synkmanagement;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SynkManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(SynkManagementApplication.class, args);
	}

	@Bean
	public ModelMapper mdelMapper() {

		return new ModelMapper();

	}
}
