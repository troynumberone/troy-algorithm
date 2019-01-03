package com.troy.algorithm;

import java.util.Arrays;
import java.util.Random;

/**
 * @author: xuboru on 2019/1/3
 *
 *  Shuffle an Array
 */
public class ShuffleAnArray
{
	class Solution
	{
		private int[] base;

		public Solution(int[] nums)
		{
			base = nums;
		}

		/** Resets the array to its original configuration and return it. */
		public int[] reset()
		{
			return base;
		}

		/** Returns a random shuffling of the array. */
		public int[] shuffle()
		{
			int[] shuffle = new int[base.length];
			Random random = new Random();
			for (int i = 0; i < base.length; i++)
			{
				shuffle[i] = base[i];
			}
			for (int i = base.length; i >= 1; i--)
			{
				swap(shuffle, i - 1, random.nextInt(i));
			}
			return shuffle;
		}

		private void swap(int[] num, int i, int j)
		{
			if (i == j)
				return;
			num[i] = num[i] ^ num[j];
			num[j] = num[i] ^ num[j];
			num[i] = num[i] ^ num[j];
		}
	}

}
