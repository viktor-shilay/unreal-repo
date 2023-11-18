package com.shilay.kafkastreamservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${elastic-search-service-URL}")
    private String elasticSearchServiceURL;

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl(elasticSearchServiceURL)
                .build();
    }
}
