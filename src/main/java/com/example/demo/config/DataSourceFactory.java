package com.example.demo.config;

import com.example.demo.entity.DbConnectionInfo;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: Binh Nguyen
 * Jun 29, 2022
 */

@Component
public class DataSourceFactory {
    private final Logger L = LoggerFactory.getLogger(this.getClass());
    private final Map<String, HikariDataSource> dataSourceMap = new ConcurrentHashMap<>();
    private final DbConnectionInfoPool dbConnectionInfoPool;

    @PostConstruct
    public void initDataSourceMap() throws Exception {
        L.info("initDataSourceMap");
        Map<String, DbConnectionInfo> dbConnectionInfoMap = dbConnectionInfoPool.getDbConnectionInfoMap();

        for (String tenantId: dbConnectionInfoMap.keySet()) {
            dataSourceMap.put(tenantId, createDataSource(dbConnectionInfoMap.get(tenantId)));
        }
    }

    public DataSourceFactory(DbConnectionInfoPool dbConnectionInfoPool) {
        this.dbConnectionInfoPool = dbConnectionInfoPool;
    }

    private HikariDataSource createDataSource(DbConnectionInfo dbConnectionInfo) throws Exception {
        L.info("createDataSource");

        if (Objects.isNull(dbConnectionInfo)) {
            throw new Exception("Not have dbConnectionInfo");
        }

        HikariConfig config = new HikariConfig();

        config.setDriverClassName(dbConnectionInfo.getDriverClassName());

        String url = "jdbc:mysql://" + dbConnectionInfo.getHost() + ":" + dbConnectionInfo.getPort() + "/" + dbConnectionInfo.getDbName();

        config.setJdbcUrl(url);
        config.setUsername(dbConnectionInfo.getUsername());
        config.setPassword(dbConnectionInfo.getPassword());
        config.setPoolName("Tenant " + dbConnectionInfo.getTenantId() + " DS's Pool");

        HikariDataSource hikariDataSource = new HikariDataSource(config);
        L.info("created dataSourceInfo: " + hikariDataSource.toString());

        return hikariDataSource;
    }

    public Map<String, HikariDataSource> getDataSourceMap() {
        L.info("getDataSourceMap");
        return this.dataSourceMap;
    }

    public void updateDataSourceMap(DbConnectionInfo dbConnectionInfo) throws Exception {
        HikariDataSource ds = createDataSource(dbConnectionInfo);
        dataSourceMap.put(dbConnectionInfo.getTenantId(), ds);
    }

    @PreDestroy
    public void onDestroy() {
        for (String tenantId: dataSourceMap.keySet()) {
            dataSourceMap.get(tenantId).close();
        }
    }
}
