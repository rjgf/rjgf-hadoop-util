package com.rjgf.hadoop.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @email: xuliandream@gmail.com
 * @author: xula
 * @date: 2020/2/4
 * @time: 19:20
 */
@Data
@ConfigurationProperties(prefix = "rjgf.hive")//需要配置前缀
public class HiveDataSourceProperties {

    private String url;

    private String username;

    private String password;

    private String driverClassName;
}
