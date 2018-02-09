package com.xjx.core.afterstart;
import java.util.Properties;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import com.xjx.core.base.BaseJob;

@Configuration
public class ApplicationAfterStart implements ApplicationRunner{
	//加 入 主 解 ， 通 过 名 称 注 入 bean
	@Autowired @Qualifier("Scheduler")
	private Scheduler scheduler;
	@Autowired @Qualifier("quartzProperties")
	private Properties quartzProperties;
	@Override
	public void run(ApplicationArguments arg0) throws Exception {
	String dailyCron = quartzProperties.getProperty("job.daily.cron");
	String painCron = quartzProperties.getProperty("job.pain.cron");
	String nutritionCron = quartzProperties.getProperty("job.nutrition.cron");
	addDob("com.shulan.ms.emr.job.DailyMessageDob", "1", dailyCron);
	addDob("com.shulan.ms.emr.job.PainMessageDob", "1", painCron);
	addDob("com.shulan.ms.emr.job.NutritionAndRecoveryMessDob", "1", nutritionCron);
	}
	
	public void addDob(String jobClassName, String jobGroupName, String cronExpression)throws Exception{
		//启动调度器
		scheduler.start();
		// 构建 job 信息
		JobDetail jobDetail = JobBuilder.newJob(getClass(jobClassName).getClass()) .withIdentity(jobClassName, jobGroupName).build();
		// 表达式调度构建器 ( 即任劳汍行的时间）
		CronScheduleBuilder scheduleBuilder = CronScheduleBuilder. cronSchedule(cronExpression);
		// 按新的 cronExpression 表达式构建一个新的 trigger
		CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(jobClassName, jobGroupName)
		.withSchedule(scheduleBuilder).build();
		try {
		scheduler.scheduleJob(jobDetail, trigger);
		} catch (SchedulerException e){
		throw new Exception(" 创建定时任务失畋");
		}
	}
	
	public static  BaseJob getClass(String classname) throws Exception{
		Class<?> clazz = Class.forName(classname);
		return (BaseJob)clazz.newInstance();
	}
}
