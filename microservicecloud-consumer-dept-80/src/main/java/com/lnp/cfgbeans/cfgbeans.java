package com.lnp.cfgbeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration  //==applicationContext.xml
public class cfgbeans {   //boot 不用applicationContext.xml 而用注解版的配置
    @Bean
    //默认是轮询算法去找服务
    @LoadBalanced  //Spring Cloud Ribbon是基于Netflix Ribbon实现的一套 客户端  负载均衡的工具
    public RestTemplate getRestTemplate(){
         return new RestTemplate();
    }

    @Bean
    public IRule myRule(){
        return new RandomRule();  //重新选择算法（随机）也可以自己外部包com.lnp2 MySelfRule中定义算法
//        return new RetryRule();  //正常的话轮询，如果有服务宕机访问错误几次之后则自动跳过此服务继续访问其他服务
    }
}
