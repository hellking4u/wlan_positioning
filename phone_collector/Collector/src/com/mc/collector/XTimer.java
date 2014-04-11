package com.mc.collector;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 
 * �����˸���ʱ����Ƶĺ���
 * ʹ��ʱ��Ҫ��ʵ�ֳ�����execute()������������Ҫʱ�������ִ�еĴ���
 * @author Chao
 *
 */
abstract public class XTimer {
	
	Timer timer;
	int cnt;
	//*************************************************************//
	
	public XTimer(){
	}
	
	/**
	 * ѭ��ִ�г���times�Σ�ÿ��period����ִ��һ�Σ�delay�����ʼ��һ��ִ��
	 * @param delay 
	 * @param period
	 * @param times
	 */
	public void Timer_DIT(long delay,long interval,int times){
		timer = new Timer();
		TimerTask task = task_DIT(times);
		timer.schedule(task, delay, interval);
	}
	
	public int progress(){
		return cnt;
	}
	
	private TimerTask task_DIT(final int times){
		TimerTask task = new TimerTask() {
			int counter = 0;
			@Override
			public void run() {
				cnt++;
				execute();
				if(++counter>=times) {
					timer.cancel();
					notice();
				}
			}
		};
		return task;
	}
	
	public void Timer_DI(long delay,long interval){
		timer = new Timer();
		TimerTask task = task_DI();
		timer.schedule(task, delay, interval);
	}
	
	private TimerTask task_DI(){
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				execute();
			}
		};
		return task;
	}
	
	public void cancel(){
		timer.cancel();
		timer.purge();
	}
	
	/**
	 * ������������ִ��������Ҫ������ָ������������MyTimer��ʱʵ��
	 */
	public abstract void execute();
	public abstract void notice();
}
