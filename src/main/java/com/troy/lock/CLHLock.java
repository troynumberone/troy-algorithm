package com.troy.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author: xuboru on 2018/12/7
 */
public class CLHLock
{
	private class CLhNode
	{
		private boolean lock = false;
	}

	private ThreadLocal<CLhNode> current = new ThreadLocal<>();
	private ThreadLocal<CLhNode> pre = new ThreadLocal<>();
	private AtomicReference<CLhNode> tail = new AtomicReference<>(new CLhNode());

	public CLHLock()
	{
		current.set(new CLhNode());
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

}
