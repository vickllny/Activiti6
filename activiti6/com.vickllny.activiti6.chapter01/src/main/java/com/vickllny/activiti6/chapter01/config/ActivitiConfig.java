package com.vickllny.activiti6.chapter01.config;

import org.activiti.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class ActivitiConfig {

    @Bean("dataSource")
    @Qualifier("dataSource")
    @Primary
    @ConfigurationProperties(prefix = "c3p0")
    public DataSource dataSource(){
        return DataSourceBuilder.create().type(com.mchange.v2.c3p0.ComboPooledDataSource.class).build();
    }

    @Bean
    public StandaloneProcessEngineConfiguration processEngineConfiguration(DataSource dataSource){
        StandaloneProcessEngineConfiguration configuration = new StandaloneProcessEngineConfiguration();
        configuration.setDataSource(dataSource);
        configuration.setDatabaseSchemaUpdate(String.valueOf(Boolean.TRUE));
        return configuration;
    }
}
