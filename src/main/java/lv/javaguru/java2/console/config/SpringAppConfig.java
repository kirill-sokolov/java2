package lv.javaguru.java2.console.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = {"lv.javaguru.java2.console"})
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
public class SpringAppConfig {
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public static DataSource dataSource(
            @Value("${spring.datasource.hikari.jdbc-url}") String jdbcUrl,
            @Value("${spring.datasource.driver-class-name}") String driverClass,
            @Value("${spring.datasource.dbcp2.username}") String userName,
            @Value("${spring.datasource.dbcp2.password}") String password) {
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(jdbcUrl);
        ds.setDriverClassName(driverClass);
        ds.setUsername(userName);
        ds.setPassword(password);
        return ds;
    }

    @Bean
    public Properties hibernateProperties(
            @Value("${spring.jooq.sql-dialect}") String dialect,
            @Value("${spring.jpa.show-sql}") boolean showSql,
//            @Value("${hibernate.format_sql}") boolean formatSql,
            @Value("${spring.jpa.hibernate.ddl-auto}") String hbm2ddl) {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", dialect);
        properties.put("hibernate.show_sql", showSql);
//        properties.put("hibernate.format_sql", formatSql);
        properties.put("hibernate.hbm2ddl.auto", hbm2ddl);
        return properties;
    }

    @Bean
    public SessionFactory sessionFactory(DataSource dataSource,
                                         @Value("${hibernate.packagesToScan}") String packagesToScan,
                                         @Qualifier("hibernateProperties") Properties properties) throws Exception {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setPackagesToScan(packagesToScan);
        sessionFactoryBean.setHibernateProperties(properties);
        sessionFactoryBean.afterPropertiesSet();
        return sessionFactoryBean.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager(SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }
}