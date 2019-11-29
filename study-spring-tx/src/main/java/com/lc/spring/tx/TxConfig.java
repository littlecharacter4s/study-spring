package com.lc.spring.tx;

import com.lc.spring.tx.config.ApplicationConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@ComponentScan("com.lc.spring.tx")
@PropertySource("classpath:conf/application.properties")
@MapperScan(basePackages={"com.lc.spring.tx.mapper"}, sqlSessionFactoryRef="sqlSessionFactory")
@EnableTransactionManagement
public class TxConfig {
    @Bean
    public DataSource dataSource(ApplicationConfig properties) {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(properties.getUrl());
        // 这个连接池可以不用配置驱动类
        dataSource.setDriverClassName(properties.getDriverClassName());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());
        return dataSource;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource, ApplicationConfig properties) throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        PathMatchingResourcePatternResolver classPathResource = new PathMatchingResourcePatternResolver();
        // 设置mybatis.xml配置
        sqlSessionFactoryBean.setConfigLocation(classPathResource.getResource(properties.getConfigLocation()));
        // 设置mapper.xml
        sqlSessionFactoryBean.setMapperLocations(classPathResource.getResources(properties.getMapperLocations()));
        // 设置实体包
        sqlSessionFactoryBean.setTypeAliasesPackage(properties.getTypeAliasesPackage());
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }

    @Bean
    public PlatformTransactionManager txManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
