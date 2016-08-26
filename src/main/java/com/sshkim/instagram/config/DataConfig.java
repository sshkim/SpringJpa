package com.sshkim.instagram.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * Created by sshkim on 2016. 8. 18..
 */

@Configuration
@EnableJpaRepositories("com.sshkim.instagram.repositories")
@PropertySource(value = {"classpath:db.properties"})
public class DataConfig {

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
    public JpaTransactionManager transactionManager(EntityManagerFactory emf){
        return new JpaTransactionManager(emf);
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
        hibernateJpaVendorAdapter.setGenerateDdl(true);
        return hibernateJpaVendorAdapter;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        localContainerEntityManagerFactoryBean.setDataSource(dataSource());
        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter());
        localContainerEntityManagerFactoryBean.setPackagesToScan("com.sshkim.instagram");

        return localContainerEntityManagerFactoryBean;
    }

//
//    @Bean
//    @Autowired
//    public DataSourceTransactionManager txManager(DataSource dataSource){
//        DataSourceTransactionManager txManager = new DataSourceTransactionManager();
//        txManager.setDataSource(dataSource);
//        return txManager;
//    }
//
//    @Bean
//    @Autowired
//    public SqlSessionFactoryBean sqlSessionFactoryBean() throws Exception {
//        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource());
//        sessionFactory.setTypeAliasesPackage("com.sshkim.instagram.dto");
//        sessionFactory.setConfigLocation(new DefaultResourceLoader().getResource("classpath:mybatis/config/mybatisConfig.xml"));
//        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/sql/*.xml"));
//        return sessionFactory;
//    }
}
