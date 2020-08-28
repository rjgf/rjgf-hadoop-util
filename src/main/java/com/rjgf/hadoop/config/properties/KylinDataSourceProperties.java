package com.rjgf.hadoop.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * kylin 数据源配置
 * @email: xuliandream@gmail.com
 * @author: xula
 * @date: 2020/2/4
 * @time: 19:20
 */
@Data
@ConfigurationProperties(prefix = "rjgf.kylin")//需要配置前缀
public class KylinDataSourceProperties {

    private String url;

    private String username;

    private String password;

    private String driverClassName;
}
