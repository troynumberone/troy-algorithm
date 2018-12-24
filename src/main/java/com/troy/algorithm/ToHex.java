package com.troy.algorithm;

/**
 * @author: xuboru on 2018/12/24
 */
public class ToHex
{

	public String toHex(int num)
	{
		if (num == 0)
			return "0";
		StringBuilder stringBuilder = new StringBuilder();
		int mask = 0xf;
		while (num != 0)
		{
			int x = num & mask;
			if (x < 10)
			{
				stringBuilder.append(x);
			}
			else
			{
				stringBuilder.append((char) (x - 10 + 'a'));
			}
			num >>>= 4;
		}
		return stringBuilder.reverse().toString();
	}
}
