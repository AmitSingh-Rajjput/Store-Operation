package com.storeOperation.serviceregistrystoreoperation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistryStoreoperationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegistryStoreoperationApplication.class, args);
	}

}
