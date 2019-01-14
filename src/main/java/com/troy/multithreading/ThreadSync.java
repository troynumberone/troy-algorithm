package com.troy.multithreading;

import java.util.concurrent.Semaphore;

/**
 * @author: xuboru on 2019/1/14
 */
public class ThreadSync
{
	static class ConditionThread extends Thread
	{
		ConditionThread(Semaphore preCond, Semaphore postCond, String text)
		{
			this.preCond = preCond;
			this.postCond = postCond;
			this.text = text;
		}

		private Semaphore preCond;
		private Semaphore postCond;
		private String text;

		@Override
		public void run()
		{
			for (int i = 0; i < 10; i++)
			{
				try
				{
					preCond.acquire();
					System.out.print(text);
					postCond.release();
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException
	{
		Semaphore semaphoreA = new Semaphore(0);
		Semaphore semaphoreB = new Semaphore(0);
		Semaphore semaphoreC = new Semaphore(1);

		Thread threadA = new ConditionThread(semaphoreC, semaphoreA, "A");
		Thread threadB = new ConditionThread(semaphoreA, semaphoreB, "B");
		Thread threadC = new ConditionThread(semaphoreB, semaphoreC, "C");

		threadA.start();
		threadB.start();
		threadC.start();
	}
}
