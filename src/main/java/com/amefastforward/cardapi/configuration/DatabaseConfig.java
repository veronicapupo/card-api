package com.amefastforward.cardapi.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {
    @Value("${database.url}")
    private String url;

    @Value("${database.username}")
    private String username;

    @Value("${database.passoword}")
    private String passoword;

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassoword() {
        return passoword;
    }
}
