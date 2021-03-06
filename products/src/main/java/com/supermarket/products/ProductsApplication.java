package com.supermarket.products;

import com.supermarket.products.controllers.ProductController;
//import com.supermarket.products.models.Microservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

import java.net.InetAddress;

@SpringBootApplication
public class ProductsApplication {

	@Autowired
	private static Environment environment;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ProductsApplication.class, args);
	}

}
