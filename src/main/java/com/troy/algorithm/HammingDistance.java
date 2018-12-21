package com.troy.algorithm;

/**
 * @author: xuboru on 2018/12/21
 */
public class HammingDistance
{
	public int hammingDistance(int x, int y)
	{
		int m = x ^ y;
		int count = 0;
		while (m > 0)
		{
			m &= (m - 1);
			count++;
		}
		return count;
	}
}
