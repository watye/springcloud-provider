package com.talelife;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.talelife.myproject.mapper")
@EnableSwagger2
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.talelife.myproject.feign"})
public class SpringcloudProviderApplication {

	public static void main(String[] args) throws Exception {
       SpringApplication.run(SpringcloudProviderApplication.class, args);
  }


}
