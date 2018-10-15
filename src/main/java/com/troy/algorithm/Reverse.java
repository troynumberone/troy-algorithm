package com.troy.algorithm;

import java.math.BigDecimal;

/**
 * @author: xuboru on 2018/10/15
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。

示例 1:

输入: 123
输出: 321
示例 2:

输入: -123
输出: -321
示例 3:

输入: 120
输出: 21
注意:

假设我们的环境只能存储 32 位有符号整数，
其数值范围是 [−231,  231 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
 */
public class Reverse
{
	public int reverse(int x)
	{
		if (x == 0)
		{
			return 0;
		}
		boolean fs = x < 0 ? true : false;
		StringBuilder stringBuilder = new StringBuilder("").append(x);
		if (fs)
		{
			stringBuilder.deleteCharAt(0);
		}
		Double resultads = Double.valueOf(stringBuilder.reverse().toString());
		resultads = fs ? -1.0 * resultads : resultads;
		if (resultads < Integer.MIN_VALUE || resultads >= Integer.MAX_VALUE)
		{
			return 0;
		}
		return resultads.intValue();
	}

	public static void main(String[] arg)
	{
		System.out.println(new Reverse().reverse(-123));
	}
}
