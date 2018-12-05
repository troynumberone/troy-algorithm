package com.troy.algorithm;

/**
 * @author: xuboru on 2018/12/5
 * https://leetcode-cn.com/explore/interview/card/bytedance/245/data-structure/1049/
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 */

import java.util.Stack;

/**
 * 使用双栈
 */
public class MinStack
{
	private Stack<Integer> stack;
	private Stack<Integer> minStack;

	public MinStack()
	{
		stack = new Stack<>();
		minStack = new Stack<>();
	}

	public void push(int x)
	{
		stack.push(x);
		if (minStack.isEmpty() || x <= minStack.peek())
			minStack.push(x);
	}

	public void pop()
	{
		if (Integer.compare(stack.pop(), minStack.peek()) == 0)
			minStack.pop();
	}

	public int top()
	{
		return stack.peek();
	}

	public int getMin()
	{
		return minStack.peek();
	}

}
