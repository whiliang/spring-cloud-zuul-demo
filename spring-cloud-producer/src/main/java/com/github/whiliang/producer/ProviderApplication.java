package com.github.whiliang.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author whiliang
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ProviderApplication {
 
  public static void main(String[] args) {
    SpringApplication.run(ProviderApplication.class, args);
  }
}