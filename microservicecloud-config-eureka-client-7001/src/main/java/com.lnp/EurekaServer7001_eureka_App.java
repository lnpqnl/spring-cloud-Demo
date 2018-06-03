package com.lnp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer   //该组件技术的相关注解标识,eurekaServer服务器端启动类，接收其他微服务注册进来
public class EurekaServer7001_eureka_App {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7001_eureka_App.class,args);
    }
}
