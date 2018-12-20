package com.troy.algorithm;

import java.util.Stack;

/**
 * @author: xuboru on 2018/12/19
 * 682. 棒球比赛
 * https://leetcode-cn.com/problems/baseball-game/
 */
public class CalPoints
{
	public int calPoints(String[] ops)
	{
		Stack<Integer> stack = new Stack<>();
		for (String s : ops)
		{
			switch (s)
			{
				case "+":
				{
					int top = stack.pop();
					int newtop = stack.peek() + top;
					stack.push(top);
					stack.push(newtop);
					break;
				}
				case "D":
				{
					stack.push(stack.peek() * 2);
					break;
				}
				case "C":
				{
					stack.pop();
					break;
				}
				default:
				{
					stack.push(Integer.valueOf(s));
				}
			}
		}
		int sum = 0;
		for (Integer s : stack)
			sum += s;
		return sum;
	}
}
