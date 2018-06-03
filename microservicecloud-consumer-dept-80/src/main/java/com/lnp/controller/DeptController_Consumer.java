package com.lnp.controller;

import com.lnp.cloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 客户端访问类(暴露给客户的接口)
 */
@RestController
public class DeptController_Consumer {
//    private static final String REST_URL_PREFIX= "http://localhost:8001";
    private static final String REST_URL_PREFIX= "http://MICROSERVICECLOUD-DEPT"; //通过名字去rureka上找相应的服务

    @Autowired
    //通过RestTemplate进行rest的调用和发出rest请求（Rest服务）
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/dept/add")
    public boolean add(Dept dept){
        //1.路径，2.参数，3.返回类型
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept,Boolean.class);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        //1.路径，2.get没有参数，3.返回类型
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
    }

    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list(){
        //1.路径，2.get没有参数，3.返回类型
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);

    }
}
