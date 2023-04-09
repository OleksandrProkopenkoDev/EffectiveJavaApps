package com.spro;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.spro.entity.Product;
import com.spro.repository.ProductRepository;

@SpringBootApplication
public class SpringDataJpaJavaguidesApplication {

	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaJavaguidesApplication.class, args);
	

	}

	@Bean
	CommandLineRunner runner(ProductRepository repo) {
		return args->{
//			Product product = new Product("asd", "aaaqweghb");
//			try {
//			repo.save(product);
//			}catch (Exception e) {
//				System.out.println("oproduct already exists!");
//			}
		};
	}
		
	
}
