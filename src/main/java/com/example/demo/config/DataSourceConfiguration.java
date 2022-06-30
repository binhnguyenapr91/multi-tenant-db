package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Binh Nguyen
 * Jun 20, 2022
 */

@Configuration
public class DataSourceConfiguration {

    private final DataSourceFactory dataSourceFactory;

    public DataSourceConfiguration(DataSourceFactory dataSourceFactory) {
        this.dataSourceFactory = dataSourceFactory;
    }

    @Bean("myDataSourceBean")
    public DataSource dataSource() {
        Map<Object, Object> targetDataSourceMap = new HashMap<>();
        for (String tenantId: dataSourceFactory.getDataSourceMap().keySet()) {
            targetDataSourceMap.put(tenantId, dataSourceFactory.getDataSourceMap().get(tenantId));
        }

        TenantRoutingDataSource customDataSource = new TenantRoutingDataSource();
        customDataSource.setTargetDataSources(targetDataSourceMap);
        return customDataSource;
    }
}
