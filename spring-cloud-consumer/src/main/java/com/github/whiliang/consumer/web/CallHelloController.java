package com.github.whiliang.consumer.web;

import com.github.whiliang.consumer.service.IProducerClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author whiliang
 */
@RestController
public class CallHelloController {

    @Autowired
    private LoadBalancerClient loadBalancer;

    @Resource
    private IProducerClientService iGalleryClientService;

    @RequestMapping("/call")
    public String call() {
        ServiceInstance serviceInstance = loadBalancer.choose("producer");
        System.out.println("服务地址：" + serviceInstance.getUri());
        System.out.println("服务名称：" + serviceInstance.getServiceId());

        String callServiceResult = new RestTemplate().getForObject(serviceInstance.getUri().toString() + "/person/123", String.class);
        System.out.println(callServiceResult);
        return callServiceResult;
    }

    @RequestMapping("/fall")
    public String fall() {
        String callServiceResult = iGalleryClientService.searchImageByTag(111L);
        System.out.println(callServiceResult);
        return callServiceResult;
    }


}