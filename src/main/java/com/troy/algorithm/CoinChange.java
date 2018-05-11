package com.troy.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoinChange
{
	public int coinChange(int[] coins, int amount)
	{
		if (coins == null || coins.length == 0)
		{
			return -1;
		}
		if (amount == 0)
		{
			return 0;
		}
		int[] count = new int[amount + 1];
		for (int i = 0; i < count.length; i++)
		{
			count[i] = -1;
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < coins.length; i++)
		{
			if (coins[i] < min)
			{
				min = coins[i];
			}
			for (int j = 1; j * coins[i] < count.length; j++)
			{
				if (count[j * coins[i]] == -1 || j < count[j * coins[i]])
				{
					count[j * coins[i]] = j;
				}
			}
		}

		for (int i = 1; i < count.length; i++)
		{
			for (int j = 1; j <= i / 2; j++)
			{
				int temp1 = count[i];
				int temp2 = count[j];
				int temp3 = count[i - j];
				int sum = temp2 + temp3;
				if (temp2 != -1 && temp3 != -1)
				{
					if (temp1 == -1 || sum < temp1)
					{
						count[i] = sum;
					}
				}
			}
		}
		//System.out.println(Arrays.toString(count));
		return count[amount];
	}

	public static void main(String[] args)
	{
		CoinChange coinChange = new CoinChange();
		System.out.println(coinChange.coinChange(new int[] { 2, 5, 10, 1
		}, 27));
	}
}
