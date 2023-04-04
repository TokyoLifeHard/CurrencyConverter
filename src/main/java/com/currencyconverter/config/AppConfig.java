package com.currencyconverter.config;


import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;


@Configuration
public class AppConfig {

    @Bean(name = "valuteAPI")
    public RestTemplate getValuteAPI(RestTemplateBuilder restTemplateBuilder){
          return restTemplateBuilder
                .setConnectTimeout(Duration.ofMillis(60000))
                .setReadTimeout(Duration.ofMillis(60000))
                .build();
    }

}
