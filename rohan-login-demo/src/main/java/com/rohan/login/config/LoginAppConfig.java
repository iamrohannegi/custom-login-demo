package com.rohan.login.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.rohan.login")
@PropertySource("classpath:persistence-mysql.properties")
public class LoginAppConfig implements WebMvcConfigurer{
	
	//Injects data from the property file 
	@Autowired
	private Environment env;
	
	//Translates view-name to appropriate URL
	@Bean
	public ViewResolver viewResolver() {
	
		InternalResourceViewResolver internalViewResolver = new InternalResourceViewResolver();
		internalViewResolver.setPrefix("/WEB-INF/view/");
		internalViewResolver.setSuffix(".jsp");
		
		return internalViewResolver;
	}
	
	//Configures database as data source based on information provided in properties file
	@Bean
	public DataSource dataSource() {
		//Connection Pool
		ComboPooledDataSource theDataSource = new ComboPooledDataSource();
		
		//Setting Jdbc Driver
		try {
			theDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		}
		catch(PropertyVetoException ex) {
			ex.printStackTrace();
		}
		
		//Setting Jdbc Properties
		theDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		theDataSource.setUser(env.getProperty("jdbc.username"));
		theDataSource.setPassword(env.getProperty("jdbc.password"));
		
		//Setting Connection Pool Settings
		theDataSource.setInitialPoolSize(getIntegerProperty("connection.pool.initialPoolSize"));
		theDataSource.setMinPoolSize(getIntegerProperty("connection.pool.minPoolSize"));
		theDataSource.setMaxPoolSize(getIntegerProperty("connection.pool.maxPoolSize"));
		theDataSource.setMaxIdleTime(getIntegerProperty("connection.pool.maxIdleTime"));
		
		return theDataSource;
	}
	
	//Allows access to static resources like css etc
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/resources/**")
                    .addResourceLocations("/resources/")
                    .setCachePeriod(31556926);
    }
	
	
	private int getIntegerProperty(String propertyName) {
		//Convert String value to Integer from properties file
		return Integer.parseInt(env.getProperty(propertyName));
	}
}
