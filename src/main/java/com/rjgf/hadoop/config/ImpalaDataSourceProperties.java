package com.rjgf.hadoop.config;

import lombok.Data;

/**
 * @email: xuliandream@gmail.com
 * @author: xula
 * @date: 2020/2/4
 * @time: 19:20
 */
@Data
public class ImpalaDataSourceProperties {

    private String url;

    private String username;

    private String password;

    private String driverClassName;

    /**
     * 别名
     */
    private String alias;

    private Boolean primary;
}
