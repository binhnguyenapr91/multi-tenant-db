package com.example.demo.api;

import com.example.demo.config.*;
import com.example.demo.entity.DbConnectionInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Binh Nguyen
 * Jun 30, 2022
 */


@RestController
@RequestMapping("/api/v1/dbConnections")
public class DbConnectionAPI {
    private final Logger L = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    DataSourceFactory dataSourceFactory;

    @Autowired
    DbConnectionInfoPool dbConnectionInfoPool;

    @GetMapping(value = "", produces = "application/json")
    public void reloadBean() throws Exception {
        DbConnectionInfo connectionInfo2 = new DbConnectionInfo();
        connectionInfo2.setTenantId("tenant2");
        connectionInfo2.setDriverClassName("com.mysql.cj.jdbc.Driver");
        connectionInfo2.setHost("localhost");
        connectionInfo2.setPort("3306");
        connectionInfo2.setDbName("base_adapter_db_tenant2");
        connectionInfo2.setUsername("root");
        connectionInfo2.setPassword("Sysadmin1234$");

        dbConnectionInfoPool.setDbConnectionInfoToMap(connectionInfo2);
        dataSourceFactory.updateDataSourceMap(connectionInfo2);

        Map<Object, Object> targetDataSourceMap = new HashMap<>();
        for (String tenantId: dataSourceFactory.getDataSourceMap().keySet()) {
            targetDataSourceMap.put(tenantId, dataSourceFactory.getDataSourceMap().get(tenantId));
        }

        TenantRoutingDataSource tenantRoutingDataSource = applicationContext.getBean("myDataSourceBean", TenantRoutingDataSource.class);
        tenantRoutingDataSource.setTargetDataSources(targetDataSourceMap);
    }
}
