package com.cat.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by wangxiaoqiang on 2017/7/6.
 */

@Configuration
@AutoConfigureAfter({ DataSourceConfig.class })
@MapperScan(basePackages = { "com.cat.mapper"})
@EnableTransactionManagement
public class MybatisConfig implements EnvironmentAware,TransactionManagementConfigurer {
    private static Log logger = LogFactory.getLog(MybatisConfig.class);

    private RelaxedPropertyResolver propertyResolver;

    @Resource(name = "dataSource")
    private DataSource dataSource;

    public void setEnvironment(Environment environment) {
        this.propertyResolver = new RelaxedPropertyResolver(environment, "mybatis.");
    }

    @Bean(name="sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() {
        try {
            SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
            sessionFactory.setDataSource(dataSource);
            Properties properties = new Properties();
            properties.setProperty("dialect", propertyResolver.getProperty("dialect"));
            sessionFactory.setConfigurationProperties(properties);
            sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(propertyResolver.getProperty("mapperLocations")));
            System.out.println(propertyResolver.getProperty("mapperLocations"));

            //Interceptor[] plugins = new Interceptor[]{new PaginationInterceptor()};
            //sessionFactory.setPlugins(plugins);
            return sessionFactory.getObject();
        } catch (Exception e) {
            logger.warn("Could not confiure mybatis session factory");
            logger.error(e);
            return null;
        }
    }

    @Bean(name="sqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean(name="transactionManager")
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }
}
