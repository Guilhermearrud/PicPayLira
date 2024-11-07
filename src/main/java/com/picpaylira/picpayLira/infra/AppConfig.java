package com.picpaylira.picpayLira.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    //In Spring Framework, the @Bean annotation is used to indicate that a method will return an object that should be managed by the Spring container.
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
