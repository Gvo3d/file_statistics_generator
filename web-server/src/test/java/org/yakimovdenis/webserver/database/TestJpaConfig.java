package org.yakimovdenis.webserver.database;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import net.sf.log4jdbc.Log4jdbcProxyDataSource;
import net.sf.log4jdbc.tools.Log4JdbcCustomFormatter;
import net.sf.log4jdbc.tools.LoggingType;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.yakimovdenis.webserver.WebServerApplication;
import org.yakimovdenis.webserver.service.WebStatisticsService;
import org.yakimovdenis.webserver.service.WebStatisticsServiceImpl;
import org.yakimovdenis.console.support.StringComparator;
import org.yakimovdenis.yaml.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@ContextConfiguration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = WebServerApplication.class)
class TestJpaConfig {
    private static final Logger LOGGER = Logger.getLogger(TestJpaConfig.class);
    private Props properties;

    public TestJpaConfig() {
        this.properties = new DataSourceYamlReader(WebServerApplication.class).getDataSourceProperties("application.yml");
    }

    @Bean
    public DataSource dataSource() {
        Log4jdbcProxyDataSource dataSource = new Log4jdbcProxyDataSource(realDataSource());
        Log4JdbcCustomFormatter log4JdbcCustomFormatter = new Log4JdbcCustomFormatter();
        log4JdbcCustomFormatter.setLoggingType(LoggingType.SINGLE_LINE);
        log4JdbcCustomFormatter.setSqlPrefix("SQL:::");
        dataSource.setLogFormatter(log4JdbcCustomFormatter);
        return dataSource;
    }

    @Bean
    public DataSource realDataSource() {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        try {
            Class.forName(properties.getDatabaseProperties().getDriverClassName());
        } catch (ClassNotFoundException e) {
            LOGGER.error(e);
        }
        try {
            comboPooledDataSource.setDriverClass(properties.getDatabaseProperties().getDriverClassName());
        } catch (PropertyVetoException e) {
            LOGGER.error(e);
        }
        comboPooledDataSource.setJdbcUrl(properties.getDatabaseProperties().getUrl());
        comboPooledDataSource.setUser(properties.getDatabaseProperties().getUsername());
        comboPooledDataSource.setPassword(properties.getDatabaseProperties().getPassword());
        return comboPooledDataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setPackagesToScan(properties.getDatabaseProperties().getModelPackage());
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setJpaProperties(jpaProperties());
        entityManagerFactoryBean.setDataSource(dataSource());
        return entityManagerFactoryBean;
    }

    @Bean(name = "transactionManager", autowire = Autowire.BY_NAME)
    public PlatformTransactionManager platformTransactionManager() {
        return new JpaTransactionManager();
    }

    @Bean(name="jpaProperties")
    Properties jpaProperties(){
        Properties jpaProperties = new Properties();
        jpaProperties.put(org.hibernate.cfg.Environment.DIALECT, properties.getDatabaseProperties().getDialect());
        return jpaProperties;
    }

    @Bean
    WebStatisticsService webstatisticsService(){
        return new WebStatisticsServiceImpl();
    }

    @Bean
    StringComparator stringComparator(){
        return new StringComparator();
    }
}
