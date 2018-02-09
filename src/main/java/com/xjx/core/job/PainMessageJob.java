package com.xjx.core.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import com.xjx.core.base.BaseJob;
import com.xjx.util.SpringContextUtil;

@Component
@Configurable
@EnableScheduling
public class PainMessageJob implements BaseJob{
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		((SimpMessagingTemplate)SpringContextUtil.
				getBeanByClass(SimpMessagingTemplate.class)).convertAndSend("topic/painInfo", "message");
	}

}
