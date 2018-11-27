package com.troy.algorithm;

/**
 * @author: xuboru on 2018/11/27
 */
public class BeautifulArray
{
	public int[] beautifulArray(int N)
	{
		if (N <= 0)
			return new int[0];
		if (N == 1)
			return new int[] { 1 };
		int[] re = new int[N];
		int[] odd = beautifulArray((N + 1) / 2);
		for (int i = 0; i < odd.length; i++)
			re[i] = odd[i] * 2 - 1;
		int[] even = beautifulArray(N / 2);
		for (int i = 0; i < even.length; i++)
			re[odd.length + i] = even[i] * 2;
		return re;
	}
}
