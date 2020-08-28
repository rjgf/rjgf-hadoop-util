package com.rjgf.hadoop.config.properties;

import lombok.Data;
import org.apache.ibatis.session.Configuration;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @email: xuliandream@gmail.com
 * @author: xula
 * @date: 2020/2/4
 * @time: 19:20
 */
@Data
@ConfigurationProperties(prefix = "rjgf.mybatis.impala")//需要配置前缀
public class ImpalaMybatisProperties {

    /**
     * 配置文件地址
     */
    private String mapperLocations;

    /**
     * 配置信息
     */
    private Configuration configuration;
}
