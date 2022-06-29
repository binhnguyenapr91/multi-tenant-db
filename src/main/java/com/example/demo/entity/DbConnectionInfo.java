package com.example.demo.entity;

/**
 * @author: Binh Nguyen
 * Jun 29, 2022
 */

public class DbConnectionInfo {
    private String tenantId;
    private String driverClassName;
    private String host;
    private String port;
    private String dbName;
    private String username;
    private String password;

    public DbConnectionInfo() {
    }

    public DbConnectionInfo(String tenantId, String driverClassName, String host, String port, String dbName, String username, String password) {
        this.tenantId = tenantId;
        this.driverClassName = driverClassName;
        this.host = host;
        this.port = port;
        this.dbName = dbName;
        this.username = username;
        this.password = password;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "DbConnectionInfo{" +
                "tenantId='" + tenantId + '\'' +
                ", driverClassName='" + driverClassName + '\'' +
                ", host='" + host + '\'' +
                ", port='" + port + '\'' +
                ", dbName='" + dbName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
