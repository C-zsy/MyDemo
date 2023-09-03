package com.chinasoft.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class JdbcConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource getData(){
        DruidDataSource j = new DruidDataSource();
        return j;
    }

}