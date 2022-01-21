package com.lin;


import com.lin.service.changeTxt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ConfigurationPropertiesScan
@EnableConfigurationProperties
@EnableCaching
@EnableTransactionManagement
public class TxtToMysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(TxtToMysqlApplication.class, args);
    }

}
