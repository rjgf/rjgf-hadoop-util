package com.rjgf.hadoop.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.rjgf.hadoop.config.properties.ImpalaMybatisProperties;
import com.rjgf.hadoop.config.properties.KylinDataSourceProperties;
import com.rjgf.hadoop.config.properties.KylinMybatisProperties;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * KYLIN 相关配置
 * @email: xuliandream@gmail.com
 * @author: xula
 * @date: 2020/8/27
 * @time: 16:28
 */
@Configuration
@EnableConfigurationProperties({KylinMybatisProperties.class,KylinDataSourceProperties.class})
@MapperScan(basePackages = {"com.rjgf.**.mapper.kylin.**"}, sqlSessionFactoryRef = "kylinSqlSessionFactory", annotationClass = HadoopMapper.class)
public class KylinConfig {


    @Autowired
    private KylinMybatisProperties kylinMybatisProperties;

    @Autowired
    private KylinDataSourceProperties kylinDataSourceProperties;


    @Bean(name = "kylinDataSource")
    public DataSource kylinDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(kylinDataSourceProperties.getUrl());
        druidDataSource.setDriverClassName(kylinDataSourceProperties.getDriverClassName());
        druidDataSource.setUsername(kylinDataSourceProperties.getUsername());
        druidDataSource.setPassword(kylinDataSourceProperties.getPassword());
        druidDataSource.setMinIdle(2);
        druidDataSource.setMaxActive(10);
        druidDataSource.setTestWhileIdle(true);
        druidDataSource.setValidationQuery("select 1");
        return druidDataSource;
    }


    // 配置mybatis
    @Bean("kylinSqlSessionFactory")
    public SqlSessionFactory kylinSqlSessionFactory(@Qualifier("kylinDataSource") DataSource kylinDataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(kylinDataSource);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(kylinMybatisProperties.getMapperLocations()));
        factoryBean.setConfiguration(kylinMybatisProperties.getConfiguration());
        return factoryBean.getObject();
    }
}
