package com.rjgf.hadoop.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Configuration
@ConfigurationProperties("rjgf.impala")
@MapperScan(basePackages = {"com.rjgf.**.mapper.impala.**"}, sqlSessionFactoryRef = "impalaSqlSessionFactory", annotationClass = Mapper.class)

public class ImpalaConfig {

    List<ImpalaDataSourceProperties> databases;

    @Value("${rjgf.mybatis.impala.mapper-locations}")
    private String mapperPath;

    @Bean(name = "impalaDataSource")
    public DataSource impalaDataSource() {
        ImpalaDynamicDataSource impalaDynamicDataSource = new ImpalaDynamicDataSource();
        Map<Object, Object> targetDataSources = new HashMap<>();
        List<String> alias = new ArrayList<>();
        for (ImpalaDataSourceProperties config : databases) {
            DruidDataSource ds = DruidDataSourceBuilder.create().build();
            ds.setUrl(config.getUrl());
            ds.setUsername(config.getUsername());
            ds.setPassword(config.getPassword());
            ds.setDriverClassName(config.getDriverClassName());
            ds.setTestWhileIdle(true);
            ds.setValidationQuery("select 1");
            targetDataSources.put(config.getAlias(), ds);
            alias.add(config.getAlias());
            impalaDynamicDataSource.setTargetDataSources(targetDataSources);
            if (config.getPrimary() != null && config.getPrimary()) {
                impalaDynamicDataSource.setDefaultTargetDataSource(ds);
            }
            impalaDynamicDataSource.setDatabaseAlias(alias);
        }
        return impalaDynamicDataSource;
    }

    public void setDatabase(List<ImpalaDataSourceProperties> databases) {
        this.databases = databases;
    }


    // 配置mybatis
    @Bean("impalaSqlSessionFactory")
    public SqlSessionFactory impalaSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(impalaDataSource());
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperPath));
        return factoryBean.getObject();
    }
}