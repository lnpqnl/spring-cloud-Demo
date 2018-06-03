package com.lnp.controller;

import com.lnp.cloud.entities.Dept;
import com.lnp.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 具体微服务类
 */
@RestController  //返回json
public class DeptController {
    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept){
        return deptService.add(dept);
    }

    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id){
        return deptService.get(id);
    }

    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    public List<Dept> list(){
        return deptService.list();
    }

    //	@Autowired
//	private DiscoveryClient client;
//    //服务发现
//    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
//    public Object discovery()
//    {
//        List<String> list = discoveryClient.getServices(); //盘点eureka中拥有的微服务
//        System.out.println("**********" + list);
//
//        List<ServiceInstance> srvList = discoveryClient.getInstances("MICROSERVICECLOUD-DEPT"); //找到某一个具体的微服务
//        for (ServiceInstance element : srvList) {
//            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
//                    + element.getUri());
//        }
//        return this.discoveryClient;
//    }
}
