package com.yiya.service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ScheduledExecutorServiceTask {

	public static ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(50);
}
