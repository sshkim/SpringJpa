package com.sshkim.instagram.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by sshkim on 2016. 8. 18..
 */

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.sshkim.instagram.repository")
@PropertySource(value = {"classpath:db.properties"})
public class PersistenceConfig {

    @Autowired
    Environment env;

    @Bean
    public DataSource dataSource(){

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("db.mysql.driverClassName"));
        dataSource.setUrl(env.getProperty("db.mysql.url"));
        dataSource.setUsername(env.getProperty("db.mysql.username"));
        dataSource.setPassword(env.getProperty("db.mysql.password"));
        dataSource.setMaxActive(Integer.parseInt(env.getProperty("db.mysql.maxActive")));
        dataSource.setDefaultAutoCommit(Boolean.parseBoolean(env.getProperty("db.mysql.defaultAutoCommit")));

        return dataSource;
    }

    @Bean
    public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
        return entityManagerFactory.createEntityManager();
    }

    @Bean
    public FactoryBean<EntityManagerFactory> entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean containerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        containerEntityManagerFactoryBean.setDataSource(dataSource());
        JpaVendorAdapter adaptor = new HibernateJpaVendorAdapter();
        containerEntityManagerFactoryBean.setJpaVendorAdapter(adaptor);
        containerEntityManagerFactoryBean.setPackagesToScan("com.sshkim.instagram.entity");
        Properties props = new Properties();
        props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
        props.setProperty("hibernate.show_sql", "true");
        props.setProperty("hibernate.hbm2ddl.auto", "validate");
        props.setProperty("hibernate.format_sql", "true");
        containerEntityManagerFactoryBean.setJpaProperties(props);
        return containerEntityManagerFactoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
        return jpaTransactionManager;
    }


}
