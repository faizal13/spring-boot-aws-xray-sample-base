package com.adcb.aws.xray;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableFeignClients(basePackages = {"com.adcb.aws.xray.service.clients"})
@MapperScan(basePackages = "com.adcb.aws.xray.dao")
public class SpringBootXRayApplication {

	private static final Logger LOG = LogManager.getLogger(SpringBootXRayApplication.class);

	public static void main(String[] args) {
		LOG.info("Starting application");

		
		SpringApplication.run(SpringBootXRayApplication.class, args);
		
	}

}
