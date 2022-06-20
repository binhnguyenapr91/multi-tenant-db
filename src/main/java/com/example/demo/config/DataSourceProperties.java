package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: Binh Nguyen
 * Jun 20, 2022
 */

@Component
@ConfigurationProperties(prefix = "tenants")
public class DataSourceProperties {

    private Map<Object, Object> dataSources = new LinkedHashMap<>();

    public Map<Object, Object> getDatasources() {
        return dataSources;
    }

    public void setDatasources(Map<String, Map<String, String>> dataSources) {
        dataSources
                .forEach((key, value) -> this.dataSources.put(key, convert(value)));
    }

    public DataSource convert(Map<String, String> source) {
        return DataSourceBuilder.create()
                .url(source.get("url"))
                .driverClassName(source.get("driverClassName"))
                .username(source.get("username"))
                .password(source.get("password"))
                .build();
    }
}
