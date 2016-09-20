package com.sshkim.instagram.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

/**
 * Created by sshkim on 2016. 8. 26..
 */

@Configuration
@ComponentScan("com.sshkim.instagram")
@PropertySource("classpath:application.properties")
public class RootConfig {

    @Autowired
    private Environment env;

    @Bean
    static PropertySourcesPlaceholderConfigurer propertySourcesPlaceHolderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

//    @Bean
//    public JavaMailSenderImpl javaMailSenderImpl() {
//        JavaMailSenderImpl mailSenderImpl = new JavaMailSenderImpl();
//        mailSenderImpl.setHost(env.getProperty("smtp.host"));
//        mailSenderImpl.setPort(env.getProperty("smtp.port", Integer.class));
//        mailSenderImpl.setProtocol(env.getProperty("smtp.protocol"));
//        mailSenderImpl.setUsername(env.getProperty("smtp.username"));
//        mailSenderImpl.setPassword(env.getProperty("smtp.password"));
//
//        Properties javaMailProps = new Properties();
//        javaMailProps.put("mail.smtp.auth", true);
//        javaMailProps.put("mail.smtp.starttls.enable", true);
//
//        mailSenderImpl.setJavaMailProperties(javaMailProps);
//
//        return mailSenderImpl;
//    }

}
