package com.troy.algorithm;

/**
 * @author: xuboru on 2018/12/24
 * 342. 4的幂
 * https://leetcode-cn.com/problems/power-of-four/
 */
public class IsPowerOfFour
{

	public boolean isPowerOfFour(int num)
	{
		return (num <= 0 || (num & (num - 1)) != 0) ? false : ((num & 0x55555555) != 0 ? true : false);
	}
}
