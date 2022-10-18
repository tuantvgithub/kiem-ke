package com.hust.gr.inventory.config;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@Configuration
@EnableMongoAuditing
//@EnableDiscoveryClient
@EnableFeignClients("com.hust.gr.inventory.adapter")
public class AppConfig {
}
