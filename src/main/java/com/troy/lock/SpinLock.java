package com.troy.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author: xuboru on 2018/12/7
 * 简单的java自旋锁,不可重入
 */
public class SpinLock
{
	private AtomicReference<Thread> cas = new AtomicReference<>();

	public void lock()
	{
		Thread thread = Thread.currentThread();
		while (!cas.compareAndSet(null, thread))
		{
			//do nothing
		}
	}

	public void unlock()
	{
		Thread thread = Thread.currentThread();
		cas.compareAndSet(thread, null);
	}
}
