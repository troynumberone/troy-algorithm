package com.troy.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author: xuboru on 2018/12/7
 */
public class CLHLock
{
	private class CLhNode
	{
		private boolean lock = false;

		private CLhNode()
		{
			System.out.println("创建" + this);
		}
	}

	private ThreadLocal<CLhNode> current = new ThreadLocal<>();
	private ThreadLocal<CLhNode> pre = new ThreadLocal<>();
	private AtomicReference<CLhNode> tail = new AtomicReference<>(new CLhNode());

	public CLHLock()
	{
		this.pre = ThreadLocal.withInitial(() -> null);
		this.current = ThreadLocal.withInitial(() -> new CLhNode());
	}

	public void lock()
	{
		current.get().lock = true;
		pre.set(tail.getAndSet(current.get()));
		while (pre.get().lock)
		{
		}
	}

	public void unlock()
	{
		current.get().lock = false;
		//节点循环使用，放弃当前节点，当前可能被其他线程引用，
		// 再次加锁可能导致需要获得锁的后驱节点由于本线程改变lock为true从而得不到锁，
		// 还可能导致环，发生死锁
		// 当该线程再次加锁的时候，使用其他线程不使用的前驱对象，
		// 相当于new一个新但是又不浪费空间
		current.set(pre.get());
	}

	public static void main(String[] arg)
	{

		CLHLock clhLock = new CLHLock();
		Thread[] threads = new Thread[5];
		for (int i = 0; i < 5; i++)
		{
			Thread thread = new Thread(() -> {
				clhLock.lock();
				System.out.println("线程" + Thread.currentThread() +
						"使用" + clhLock.current.get() + "pre" + clhLock.pre.get());
				clhLock.unlock();
				try
				{
					Thread.sleep(1000);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				clhLock.lock();
				System.out.println("线程" + Thread.currentThread() +
						"使用" + clhLock.current.get() + "pre" + clhLock.pre.get());
				clhLock.unlock();
			});
			threads[i] = thread;
		}

		System.out.println("运行线程");
		for (int i = 0; i < 5; i++)
		{
			threads[i].start();
		}
	}

}
