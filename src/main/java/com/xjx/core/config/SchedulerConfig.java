package com.xjx.core.config;

import java.io.IOException;
import java.util.Properties;

import org.quartz.Scheduler;
import org.quartz.ee.servlet.QuartzInitializerListener;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
/**
 * 定时任务配置类
 * @author xujunxia
 *
 */
@Configuration
public class SchedulerConfig {
	
	@Bean(name="SchedulerFactory")
	public SchedulerFactoryBean schedulerFactoryBean() throws IOException {
		SchedulerFactoryBean factory = new SchedulerFactoryBean();
		factory.setQuartzProperties(quartzProperties());
		return factory;
	}
	
	
	@Bean(name="quartzProperties")
	public Properties quartzProperties() throws IOException {
		PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
		propertiesFactoryBean.setLocation(new ClassPathResource("/quartz.properties"));
		// 在 quartz. properties 中的属性被读取并注入后再初始化对象
		propertiesFactoryBean.afterPropertiesSet();
		return propertiesFactoryBean.getObject();
	}

	/*
	* quartz 初始化监听器
	*/
	@Bean
	public QuartzInitializerListener executorListener() {
		return new QuartzInitializerListener();
	}
	
	/*
	*  通过 Scheduler Factory Bean  获取 Scheduler ^!实例
	*/
	@Bean (name="Scheduler")
	public Scheduler scheduler() throws IOException {
	return schedulerFactoryBean().getScheduler();
	}
		
}		
