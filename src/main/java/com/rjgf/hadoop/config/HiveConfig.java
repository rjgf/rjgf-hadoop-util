package com.rjgf.hadoop.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;


@Configuration
@EnableConfigurationProperties({HiveDataSourceProperties.class,HiveMybatisProperties.class})
@AutoConfigureAfter(HiveMybatisProperties.class)
@MapperScan(basePackages = {"com.rjgf.**.mapper.hive.**"},sqlSessionFactoryRef = "hiveSqlSessionFactory",annotationClass = HadoopMapper.class)
public class HiveConfig {

	@Autowired
	private HiveDataSourceProperties hiveDataSourceProperties;

	@Autowired
	private HiveMybatisProperties hiveMybatisProperties;


	@Bean(name = "hiveJdbcDataSource")
	public DataSource hiveJdbcDataSource() {
		DruidDataSource druidDataSource = new DruidDataSource();
		druidDataSource.setUrl(hiveDataSourceProperties.getUrl());
		druidDataSource.setDriverClassName(hiveDataSourceProperties.getDriverClassName());
		druidDataSource.setUsername(hiveDataSourceProperties.getUsername());
		druidDataSource.setMinIdle(2);
		druidDataSource.setMaxActive(10);
		druidDataSource.setTestWhileIdle(true);
		druidDataSource.setValidationQuery("select 1");
		return druidDataSource;
	}

	@Bean("hiveSqlSessionFactory")
	public SqlSessionFactory hiveSqlSessionFactory() throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(hiveJdbcDataSource());
		factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(hiveMybatisProperties.getMapperLocations()));
		return factoryBean.getObject();
	}
}