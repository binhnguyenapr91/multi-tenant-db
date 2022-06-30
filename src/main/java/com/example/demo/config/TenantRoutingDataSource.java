package com.example.demo.config;

import com.example.demo.interceptor.ThreadTenantStorage;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.Map;

/**
 * @author: Binh Nguyen
 * Jun 20, 2022
 */

public class TenantRoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return ThreadTenantStorage.getTenantId();
    }

    public void reload(Map<Object,Object> newTargetDataSources){
        this.setTargetDataSources(newTargetDataSources);
    }
}
