package com.example.demo.config;

import com.example.demo.entity.DbConnectionInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Binh Nguyen
 * Jun 29, 2022
 */

@Component
public class DbConnectionInfoPool {
    private final Logger L = LoggerFactory.getLogger(this.getClass());
    private final Map<String, DbConnectionInfo> dbConnectionInfoMap = new HashMap<>();

    @PostConstruct
    public void initDbConnectionInfoMap() {
        DbConnectionInfo connectionInfo1 = new DbConnectionInfo();
        connectionInfo1.setTenantId("tenant1");
        connectionInfo1.setDriverClassName("com.mysql.cj.jdbc.Driver");
        connectionInfo1.setHost("localhost");
        connectionInfo1.setPort("3306");
        connectionInfo1.setDbName("base_adapter_db_tenant1");
        connectionInfo1.setUsername("root");
        connectionInfo1.setPassword("Sysadmin1234$");

        dbConnectionInfoMap.put(connectionInfo1.getTenantId(), connectionInfo1);

        L.info("initDbConnectionMap");
        for (String item: dbConnectionInfoMap.keySet()) {
            L.info("dbConnectionInfoMap item: " + dbConnectionInfoMap.get(item).toString());
        }
    }

    public Map<String, DbConnectionInfo> getDbConnectionInfoMap() {
        return this.dbConnectionInfoMap;
    }

    public void setDbConnectionInfoToMap(DbConnectionInfo dbConnectionInfo) {
        this.dbConnectionInfoMap.put(dbConnectionInfo.getTenantId(), dbConnectionInfo);
        for (String item: dbConnectionInfoMap.keySet()) {
            L.info("setDbConnectionInfoToMap");
            L.info("dbConnectionInfoMap item: " + dbConnectionInfoMap.get(item).toString());
        }
    }
}
