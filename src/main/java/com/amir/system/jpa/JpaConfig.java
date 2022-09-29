package com.amir.system.jpa;

import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@EnableJpaRepositories(basePackages =  {"com.amir.system.config.security" , "com.amir.book", "com.amir.user"})
@Configuration
@PropertySource("classpath:database.properties")
@EnableTransactionManagement(proxyTargetClass = true)
public class JpaConfig {

    @Autowired
    Environment env;


    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
        factoryBean.setPackagesToScan("com.amir.system.config.security",
                                        "com.amir.user",
                                         "com.amir.book");
        factoryBean.setJpaProperties(hibernateProperties());
        return factoryBean;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.MYSQL);
        adapter.setShowSql(true);
        return adapter;
    }

    @Bean("datasource")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty("database.datasource.driver"));
        dataSource.setUrl(env.getRequiredProperty("database.datasource.url"));
        dataSource.setUsername(env.getRequiredProperty("database.datasource.username"));
        dataSource.setPassword(env.getRequiredProperty("database.datasource.password"));

        return dataSource;
    }

    public Properties hibernateProperties() {

        Properties properties = new Properties();
        properties.put(AvailableSettings.SHOW_SQL, "true");
        properties.put(AvailableSettings.FORMAT_SQL, "true");
        properties.put(AvailableSettings.HBM2DDL_AUTO, "update");
        properties.put(AvailableSettings.DIALECT, "org.hibernate.dialect.MySQL55Dialect");
        return properties;

    }

    @Bean(name = "transactionManager")
    @Autowired
    public JpaTransactionManager jpaTransactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
        return jpaTransactionManager;

    }
}