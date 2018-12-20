package com.troy.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: xuboru on 2018/12/20
 * 225. 用队列实现栈
 * https://leetcode-cn.com/problems/implement-stack-using-queues/
 */
class MyStack
{

	private Queue<Integer> queue1 = new LinkedList<>();
	private Queue<Integer> queue2 = new LinkedList<>();
	private int size = 0;

	/** Initialize your data structure here. */
	public MyStack()
	{

	}

	/** Push element x onto stack. */
	public void push(int x)
	{
		if (queue1.isEmpty() && queue2.isEmpty())
		{
			queue1.add(x);
		}
		else if (!queue1.isEmpty())
		{
			queue1.add(x);
		}
		else
		{
			queue2.add(x);
		}
		size++;

	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop()
	{
		if (queue1.isEmpty())
		{
			return pop(queue2, queue1);
		}
		else
		{
			return pop(queue1, queue2);
		}
	}

	public int pop(Queue<Integer> from, Queue<Integer> to)
	{
		for (int i = 0; i < size - 1; i++)
		{
			to.add(from.poll());
		}
		size--;
		return from.poll();
	}

	public int top(Queue<Integer> from, Queue<Integer> to)
	{
		for (int i = 0; i < size - 1; i++)
		{
			to.add(from.poll());
		}
		int re = from.poll();
		to.add(re);
		return re;
	}

	/** Get the top element. */
	public int top()
	{
		if (queue1.isEmpty())
		{
			return top(queue2, queue1);
		}
		else
		{
			return top(queue1, queue2);
		}
	}

	/** Returns whether the stack is empty. */
	public boolean empty()
	{
		return size == 0;
	}
}
