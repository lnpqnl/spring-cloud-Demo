package com.lnp2.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/***
 * 负载均衡 自定义算法
 */
@Configuration
public class MySelfRule  {
    @Bean
    public IRule myRule(){
        //return new RandomRule();// Ribbon默认是轮询，我自定义为随机
        //return new RoundRobinRule();// Ribbon默认是轮询，我自定义为随机

        return new RandomRule_ZY();  // 我自定义为每台机器5次
    }
}
