package com.xjx.core.base;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public interface BaseJob extends Job{

	@Override
	default void execute(JobExecutionContext arg0) throws JobExecutionException {
		
	}

}
