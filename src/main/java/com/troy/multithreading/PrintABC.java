package com.troy.multithreading;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: xuboru on 2019/1/14
 */
public class PrintABC
{

	public static void main(String[] args)
	{
		AtomicInteger atomicInteger=new AtomicInteger(0);
		Runnable runnableA = () -> {
			for (int i = 0; i < 10; i++)
			{
				boolean flag=true;
				while (flag){
					synchronized (atomicInteger)
					{
						if (atomicInteger.get()%3==0){
							System.out.println(i+"-"+Thread.currentThread().getName());
							atomicInteger.addAndGet(1);
							flag=false;
						}
						try
						{
							atomicInteger.notifyAll();
							atomicInteger.wait();
						}
						catch (InterruptedException e)
						{
							e.printStackTrace();
						}
					}
				}

			}
		};
		Runnable runnableB = () -> {
			for (int i = 0; i < 10; i++)
			{
				boolean flag=true;
				while (flag){
					synchronized (atomicInteger)
					{
						if (atomicInteger.get()%3==1){
							System.out.println(i+"-"+Thread.currentThread().getName());
							atomicInteger.addAndGet(1);
							flag=false;
						}
						try
						{
							atomicInteger.notifyAll();
							atomicInteger.wait();
						}
						catch (InterruptedException e)
						{
							e.printStackTrace();
						}
					}
				}

			}
		};
		Runnable runnableC = () -> {
			for (int i = 0; i < 10; i++)
			{
				boolean flag=true;
				while (flag){
					synchronized (atomicInteger)
					{
						if (atomicInteger.get()%3==2){
							System.out.println(i+"-"+Thread.currentThread().getName());
							atomicInteger.addAndGet(1);
							flag=false;
						}
						try
						{
							atomicInteger.notifyAll();
							atomicInteger.wait();
						}
						catch (InterruptedException e)
						{
							e.printStackTrace();
						}
					}
				}

			}
		};


		Thread threadA=new Thread(runnableA,"A");
		Thread threadB=new Thread(runnableB,"B");
		Thread threadC=new Thread(runnableC,"C");
		threadA.start();
		threadB.start();
		threadC.start();
	}
}
