package com.albert.springboot.thymeleafdemo.config;

import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "securityEntityManagerFactory",
        transactionManagerRef = "securityTransactionManager",
        basePackages = {"com.albert.springboot.thymeleafdemo.dao"})
public class SecurityRepositoryConfig {
	
	@Autowired
    JpaVendorAdapter jpaVendorAdapter;

    @Value("${security.datasource.jdbc-url}")
    private String databaseUrl;

    @Value("${security.datasource.username}")
    private String username;

    @Value("${security.datasource.password}")
    private String password;

    @Value("${security.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${security.datasource.hibernate.dialect}")
    private String dialect;

    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(databaseUrl, username, password);
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }

    @Bean(name = "securityEntityManager")
    public EntityManager entityManager() {
        return entityManagerFactory().createEntityManager();
    }

    @Bean(name = "securityEntityManagerFactory")
    public EntityManagerFactory entityManagerFactory() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", dialect);

        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource());
        emf.setJpaVendorAdapter(jpaVendorAdapter);
        emf.setPackagesToScan("com.albert.springboot.thymeleafdemo.entity");   // <- package for entities
        emf.setPersistenceUnitName("securityPersistenceUnit");
        emf.setJpaProperties(properties);
        emf.afterPropertiesSet();
        return emf.getObject();
    }

    @Bean(name = "securityTransactionManager")
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory());
    }

}
