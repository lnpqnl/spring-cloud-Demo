package com.lnp;

import com.lnp2.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient //本服务启动后会自动注册进eureka服务端
//在启动“MICROSERVICECLOUD-DEPT”该微服务的时候就能去加载我们的自定义Ribbon配置类，从而使配置生效
//@RibbonClient(name="MICROSERVICECLOUD-DEPT",configuration=MySelfRule.class)
@RibbonClient(name="MICROSERVICECLOUD-DEPT",configuration=MySelfRule.class) //自定义算法配置
public class DeptConsumer80_App {

    public static void main(String[] args) {

        SpringApplication.run(DeptConsumer80_App.class,args);
    }
}
