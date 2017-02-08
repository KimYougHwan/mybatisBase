package com.noaa.tcdis.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DataSourceConfig {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		BasicDataSource datasource = new BasicDataSource();
		datasource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		datasource.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:fire");
		datasource.setUsername("tcdis_2016");
		datasource.setPassword("tcdis_2016");
		datasource.setValidationQuery("SELECT 1 from dual");
		datasource.setTestWhileIdle(true);
		datasource.setTimeBetweenEvictionRunsMillis(60000);
		datasource.setInitialSize(11);
		datasource.setMaxTotal(11);
		datasource.setMaxIdle(11);
		datasource.setMaxWaitMillis(7000);
		datasource.setRemoveAbandonedTimeout(5);
		datasource.setRemoveAbandonedOnBorrow(true);
		datasource.setRemoveAbandonedOnMaintenance(true);
		datasource.setDefaultAutoCommit(true);
		
		return datasource;
	}
	
	@Bean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
	
}
