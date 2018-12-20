package com.troy.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author: xuboru on 2018/12/20
 * 496. 下一个更大元素 I
 * https://leetcode-cn.com/problems/next-greater-element-i/
 */
public class NextGreaterElement
{
	public int[] nextGreaterElement(int[] nums1, int[] nums2)
	{
		Stack<Integer> stack = new Stack<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int a : nums2)
		{
			while (!stack.isEmpty() && stack.peek() < a)
			{
				map.put(stack.pop(), a);
			}
			stack.push(a);
		}
		int[] re = new int[nums1.length];
		for (int i = 0; i < nums1.length; i++)
		{
			re[i] = map.getOrDefault(nums1[i], -1);
		}
		return re;
	}
}
