package com.example.demo2.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class MysqlDataSourceConfig {

    private String driver = "com.mysql.cj.jdbc.Driver";

    private String url = "jdbc:mysql://mysql:3306/test?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai";

    private String username = "root";

    private String password = "123456";

    @Bean(name = "dataSource")
    public DataSource mysql() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        return ds;
    }
}