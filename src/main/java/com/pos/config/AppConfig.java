package com.pos.config;


import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.pos")
@EnableTransactionManagement
public class AppConfig  {

   @Bean
   public DataSource dataSource() {
       DriverManagerDataSource ds = new DriverManagerDataSource();
       ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
       ds.setUrl("jdbc:mysql://mysql-3484ac59-xinggege10-68bd.g.aivencloud.com:10986/WebJWD");
       ds.setUsername("avnadmin");
       ds.setPassword("AVNS_znaOmJAotSDvpqxodYN");
       return ds;
   }



   @Bean
   public LocalSessionFactoryBean sessionFactory() {
       LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
       sessionFactory.setDataSource(dataSource());
       sessionFactory.setPackagesToScan("com.pos.model");
       Properties props = new Properties();
       props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
       props.setProperty("hibernate.hbm2ddl.auto", "update");
       props.setProperty("hibernate.show_sql", "true");
       props.setProperty("hibernate.format_sql", "true");
       sessionFactory.setHibernateProperties(props);
       return sessionFactory;
   }


   @Bean
   public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
       return new HibernateTransactionManager(sessionFactory);
   }


    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

}
