package com.troy.algorithm;

/**
 * @author: xuboru on 2018/12/21
 * 371. 两整数之和
 * https://leetcode-cn.com/problems/sum-of-two-integers/
 */
public class GetSum
{
	public int getSum(int a, int b)
	{
		return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
	}
}
