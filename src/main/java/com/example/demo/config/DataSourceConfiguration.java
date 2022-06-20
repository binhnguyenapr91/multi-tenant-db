package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author: Binh Nguyen
 * Jun 20, 2022
 */

@Configuration
public class DataSourceConfiguration {

    private final com.example.demo.config.DataSourceProperties dataSourceProperties;

    public DataSourceConfiguration(DataSourceProperties dataSourceProperties) {
        this.dataSourceProperties = dataSourceProperties;
    }

    @Bean
    public DataSource dataSource() {
        TenantRoutingDataSource customDataSource;
        customDataSource = new TenantRoutingDataSource();
        customDataSource.setTargetDataSources(
                dataSourceProperties.getDatasources());
        return customDataSource;
    }
}
