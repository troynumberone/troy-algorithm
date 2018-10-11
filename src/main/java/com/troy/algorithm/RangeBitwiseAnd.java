package com.troy.algorithm;

import java.math.BigDecimal;

/**
 * @author: xuboru on 2018/10/10
 * 数字范围按位与
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。

示例 1:

输入: [5,7]
输出: 4
示例 2:

输入: [0,1]
输出: 0
 */
public class RangeBitwiseAnd
{
	public int rangeBitwiseAnd(int m, int n)
	{
		//从10XXXXXX到10XXXXXXX，
		// 中间必然要经历所有的状态，那么相当于XXXXXX部分肯定与完后都是0，只保留了第一个数字。
		int count = 0;
		while(n != m)
		{
			m >>= 1;
			n >>= 1;
			count++;
		}
		return (m<<count);


	}

	public static void main(String[] arg)
	{
		RangeBitwiseAnd rangeBitwiseAnd = new RangeBitwiseAnd();
		System.out.println(rangeBitwiseAnd.rangeBitwiseAnd(5, 7));
	}
}
