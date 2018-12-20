package com.troy.algorithm;

import java.util.Stack;

/**
 * @author: xuboru on 2018/12/20
 * 232. 用栈实现队列
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 */
public class MyQueue
{
	private Stack<Integer> stack1 = new Stack<>();
	private Stack<Integer> stack2 = new Stack<>();

	/** Initialize your data structure here. */
	public MyQueue()
	{

	}

	/** Push element x to the back of queue. */
	public void push(int x)
	{
		while (!stack2.isEmpty())
		{
			stack1.push(stack2.pop());
		}
		stack1.push(x);
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop()
	{
		while (!stack1.isEmpty())
		{
			stack2.push(stack1.pop());
		}
		return stack2.pop();
	}

	/** Get the front element. */
	public int peek()
	{
		while (!stack1.isEmpty())
		{
			stack2.push(stack1.pop());
		}
		return stack2.peek();
	}

	/** Returns whether the queue is empty. */
	public boolean empty()
	{
		return stack1.isEmpty() && stack2.isEmpty();
	}
}
