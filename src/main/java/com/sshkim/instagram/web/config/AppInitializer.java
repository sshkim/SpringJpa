package com.sshkim.instagram.web.config;

import com.sshkim.instagram.config.PersistenceConfig;
import com.sshkim.instagram.config.RootConfig;
import com.sshkim.instagram.web.config.WebConfig;
import org.apache.tiles.web.util.TilesDecorationFilter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * Created by sshkim on 2016. 8. 13..
 */
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{
                RootConfig.class,
                PersistenceConfig.class
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{
                WebConfig.class
        };
    }

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");

        return new Filter[]{
                characterEncodingFilter
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
