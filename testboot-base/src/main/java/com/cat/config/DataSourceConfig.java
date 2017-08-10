package com.cat.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
//import com.cat.log.ILogger;
//import com.cat.log.LoggerFactory;



/**
 * Created by wangxiaoqiang on 2017/7/6.
 */
@Configuration
//@PropertySource("classpath:datasource.properties")
@EnableTransactionManagement
public class DataSourceConfig implements EnvironmentAware {
    //	@Autowired
//    private Environment env;
    private RelaxedPropertyResolver propertyResolver;

    //private static ILogger log = LoggerFactory.getLogger(DatasourceConfig.class);

    public void setEnvironment(Environment env) {
        this.propertyResolver = new RelaxedPropertyResolver(env, "dataSource.");
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(getDataSource());
    }

    @Bean(name = "dataSource", destroyMethod = "close", initMethod = "init")
    public DataSource getDataSource() {
        //log.debug("Configruing Write DataSource");
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(propertyResolver.getProperty("url"));
        datasource.setDriverClassName(propertyResolver.getProperty("driverClassName"));
        datasource.setUsername(propertyResolver.getProperty("username"));
        datasource.setPassword(propertyResolver.getProperty("password"));
        datasource.setInitialSize(Integer.parseInt(propertyResolver.getProperty("initialSize")));
        datasource.setMinIdle(Integer.parseInt(propertyResolver.getProperty("minIdle")));
        datasource.setMaxActive(Integer.parseInt(propertyResolver.getProperty("maxActive")));
        datasource.setMaxWait(Integer.parseInt(propertyResolver.getProperty("maxWaitMillis")));
        datasource.setTimeBetweenEvictionRunsMillis(Integer.parseInt(propertyResolver.getProperty("timeBetweenEvictionRunsMillis")));
        datasource.setMinEvictableIdleTimeMillis(Integer.parseInt(propertyResolver.getProperty("minEvictableIdleTimeMillis")));
        datasource.setValidationQuery(propertyResolver.getProperty("validationQuery"));
        return datasource;
    }
}
