package org.yakimovdenis.console.database;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import net.sf.log4jdbc.Log4jdbcProxyDataSource;
import net.sf.log4jdbc.tools.Log4JdbcCustomFormatter;
import net.sf.log4jdbc.tools.LoggingType;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import org.yakimovdenis.console.dao.FileStatisticsDao;
import org.yakimovdenis.console.dao.FileStatisticsDaoImpl;
import org.yakimovdenis.console.database.yaml.DataSourceYamlReader;
import org.yakimovdenis.console.database.yaml.DatabaseProperties;
import org.yakimovdenis.console.database.yaml.Props;
import org.yakimovdenis.console.service.StatisticsService;
import org.yakimovdenis.console.service.StatisticsServiceImpl;
import org.yakimovdenis.console.support.FileStatisticsRowMapper;
import org.yakimovdenis.console.support.LineStatisticsRowMapper;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@ContextConfiguration
@EnableTransactionManagement
public class TestDAOConfig implements TransactionManagementConfigurer {
    private static final Logger LOGGER = Logger.getLogger(TestDAOConfig.class);
    private Props properties;

    public TestDAOConfig() {
        this.properties = DataSourceYamlReader.getDataSourceProperties();
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
            e.printStackTrace();
        }
        try {
            comboPooledDataSource.setDriverClass(properties.getDatabaseProperties().getDriverClassName());
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        comboPooledDataSource.setJdbcUrl(properties.getDatabaseProperties().getUrl());
        comboPooledDataSource.setUser(properties.getDatabaseProperties().getUsername());
        comboPooledDataSource.setPassword(properties.getDatabaseProperties().getPassword());
        return comboPooledDataSource;
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
        return new NamedParameterJdbcTemplate(dataSource());
    }

    @Bean
    FileStatisticsDao fileStatisticsDao(){
        return new FileStatisticsDaoImpl();
    }

    @Bean
    StatisticsService statisticsService(){
        return new StatisticsServiceImpl();
    }

    @Bean
    LineStatisticsRowMapper lineStatisticsRowMapper(){
        return new LineStatisticsRowMapper();
    }

    @Bean
    FileStatisticsRowMapper fileStatisticsRowMapper(){
        return new FileStatisticsRowMapper();
    }
}
