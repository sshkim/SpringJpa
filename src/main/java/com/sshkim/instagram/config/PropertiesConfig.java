package com.sshkim.instagram.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

/**
 * Created by sshkim on 2016. 8. 21..
 */

@Configuration
@PropertySource("classpath:db.properties")
public class PropertiesConfig {

    @Bean
    static PropertySourcesPlaceholderConfigurer propertySourcesPlaceHolderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }


}
