package com.troy.multithreading;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author: xuboru on 2018/12/6
 */
public class PrintOddEven
{
	public static void main(String[] args)
	{
		AtomicLong count = new AtomicLong(1);
		Object o = new Object();
		Runnable odd = () -> {
			while (count.intValue() <= 100)
			{
				synchronized (o)
				{
					if (count.intValue() % 2 == 1)
					{
						System.out.println(count.getAndAdd(1));
					}
					o.notify();
					try
					{
						o.wait();
					}
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				}
			}
		};
		Runnable even = () -> {
			while (count.intValue() <= 100)
			{
				synchronized (o)
				{
					if (count.intValue() % 2 == 0)
					{
						System.out.println(count.getAndAdd(1));
					}
					o.notify();
					try
					{
						o.wait();
					}
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				}
			}
		};
		Thread thread=new Thread(odd);
		Thread thread2=new Thread(even);
		thread.start();
		thread2.start();
	}
}
