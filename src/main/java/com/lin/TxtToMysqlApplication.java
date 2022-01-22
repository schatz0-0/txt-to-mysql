package com.lin;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@ConfigurationPropertiesScan
@EnableConfigurationProperties
@EnableCaching
public class TxtToMysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(TxtToMysqlApplication.class, args);
    }

}
