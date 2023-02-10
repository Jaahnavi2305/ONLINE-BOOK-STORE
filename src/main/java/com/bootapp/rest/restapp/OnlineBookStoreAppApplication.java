package com.bootapp.rest.restapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication

@OpenAPIDefinition(info=@Info(title="OnlineBookStore",version="1.0",description="An API used for buying books online."))
public class OnlineBookStoreAppApplication{
	public static void main(String[] args) {
		SpringApplication.run(OnlineBookStoreAppApplication.class, args);
	}

<<<<<<< HEAD

}
=======
}


>>>>>>> 689240292bfbd48eb72d7d27c237ebebcddfeaf1
