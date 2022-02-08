package com.github.whiliang.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author whiliang
 */
@FeignClient(name = "producer",fallback = IProducerClientService.IProducerClientServiceFallback.class)
public interface IProducerClientService {


    @GetMapping("/person/{id}")
    String searchImageByTag(@PathVariable Long id);

    @Component
    class IProducerClientServiceFallback implements IProducerClientService {

        private static final Logger logger = LoggerFactory.getLogger(IProducerClientServiceFallback.class);

        @Override
        public String searchImageByTag(Long id) {
            logger.error("feign调用imageSearch异常，入参：{}", id);
            return null;
        }
    }
}