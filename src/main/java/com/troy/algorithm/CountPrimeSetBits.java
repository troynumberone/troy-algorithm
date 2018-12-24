package com.troy.algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: xuboru on 2018/12/24
 * 762. 二进制表示中质数个计算置位
 * https://leetcode-cn.com/problems/prime-number-of-set-bits-in-binary-representation/
 */
public class CountPrimeSetBits
{
	private Set<Integer> set = new HashSet<>();

	{
		set.addAll(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19));
	}

	public int countPrimeSetBits(int L, int R)
	{
		int re = 0;
		for (int i = L; i <= R; i++)
		{
			int x = i;
			int count = 0;
			while (x != 0)
			{
				x &= x - 1;
				count++;
			}
			if (isPrimeNumber(count))
				re++;
		}
		return re;
	}

	public boolean isPrimeNumber(int count)
	{
		return set.contains(count);
	}
}
