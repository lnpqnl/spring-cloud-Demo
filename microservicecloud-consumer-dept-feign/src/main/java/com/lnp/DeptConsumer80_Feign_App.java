package com.lnp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient //本服务启动后会自动注册进eureka服务端
@EnableFeignClients(basePackages= {"com.lnp.cloud"})
@ComponentScan("com.lnp")
public class DeptConsumer80_Feign_App {

    public static void main(String[] args) {

        SpringApplication.run(DeptConsumer80_Feign_App.class,args);
    }
}
