package com.duruo;

import com.duruo.common.filter.htmlFilter;
import com.github.pagehelper.PageHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

@SpringBootApplication
//@ServletComponentScan("com.duruo.common.filter")
public class WebresourceApplication {

	//配置mybatis的分页插件pageHelper
	@Bean
	public PageHelper pageHelper(){
		PageHelper pageHelper = new PageHelper();
		Properties properties = new Properties();
		properties.setProperty("offsetAsPageNum", "true");
		properties.setProperty("rowBoundsWithCount", "true");
		properties.setProperty("reasonable", "true");
		properties.setProperty("dialect", "mysql");    //配置mysql数据库的方言
		pageHelper.setProperties(properties);
		return pageHelper;
	}

	//配置过滤器来过滤没有登录的用户
	@Bean
	public FilterRegistrationBean registFilter(){
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter( new htmlFilter());
		registrationBean.addUrlPatterns("*.html");
		registrationBean.setName("htmlFilter");
		registrationBean.setOrder(1);
		return registrationBean;
	}

	public static void main(String[] args) {
		SpringApplication.run(WebresourceApplication.class, args);
	}
}
