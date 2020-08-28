package com.rjgf.hadoop.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.apache.ibatis.session.Configuration;

/**
 * @email: xuliandream@gmail.com
 * @author: xula
 * @date: 2020/2/4
 * @time: 19:20
 */
@Data
@ConfigurationProperties(prefix = "rjgf.mybatis.kylin")//需要配置前缀
public class KylinMybatisProperties {

    /**
     * 配置文件地址
     */
    private String mapperLocations;

    /**
     * 配置信息
     */
    private Configuration configuration;
}
