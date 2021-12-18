package com.sporty.SportyApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.sporty.repository.OrderItemsRepository;
import com.sporty.repository.OrdersRepository;
import com.sporty.repository.ProductCategoryRepository;
import com.sporty.repository.ProductsRepository;
import com.sporty.repository.UsersRepository;

@SpringBootApplication
@EntityScan("com.sporty.entity")
@EnableJpaRepositories(basePackageClasses= {UsersRepository.class,ProductCategoryRepository.class,ProductsRepository.class,OrdersRepository.class,OrderItemsRepository.class})
@ComponentScan(basePackages= {"com.sporty.entity","com.sporty.repository","com.sporty.service","com.sporty.service.impl","com.sporty.controller"})
public class SportyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportyApplication.class, args);
	}

}
