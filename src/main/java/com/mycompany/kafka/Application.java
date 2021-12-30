package com.mycompany.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
//@MapperScan("com.gwxy.shopping.dao")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Bean    //必须new 一个RestTemplate并放入spring容器当中,否则启动时报错

	public RestTemplate restTemplate() {
		return new RestTemplate();
	}


}
