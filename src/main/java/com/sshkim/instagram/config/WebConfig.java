package com.sshkim.instagram.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.nio.charset.Charset;

/**
 * Created by sshkim on 2016. 8. 13..
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.sshkim.instagram.controller")
public class WebConfig extends WebMvcConfigurerAdapter {

    /*
     * Configure ContentNegotiationManager
     */
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.ignoreAcceptHeader(true);
        Charset charset = Charset.forName("UTF-8");
        MediaType mediaType = new MediaType("application", "json", charset);
        configurer.defaultContentType(mediaType);

    }

}
