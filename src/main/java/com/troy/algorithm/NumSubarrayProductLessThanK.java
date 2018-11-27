package com.troy.algorithm;

import java.util.Arrays;

/**
 * @author: xuboru on 2018/10/25
 * 给定一个正整数数组 nums。

找出该数组内乘积小于 k 的连续的子数组的个数。

示例 1:

输入: nums = [10,5,2,6], k = 100
输出: 8
解释: 8个乘积小于100的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
说明:

0 < nums.length <= 50000
0 < nums[i] < 1000
0 <= k < 10^6
 */
public class NumSubarrayProductLessThanK
{
	public int numSubarrayProductLessThanK(int[] nums, int k)
	{
		if (k == 0)
			return 0;
		double[] s = new double[nums.length + 1];
		s[0] = 1;
		for (int i = 1; i <= nums.length; i++)
		{
			s[i] = nums[i - 1] * s[i - 1];

		}
		int count = 0;
		for (int i = 0; i <= nums.length; i++)
		{
			for (int j = nums.length; j > i; j--)
			{
				if (s[j] / s[i] < k)
				{
					count += 1;
				}
			}
		}
		return count;
		//todo error
	}

	public static void main(String[] arg)
	{
		System.out.println(new NumSubarrayProductLessThanK()
				.numSubarrayProductLessThanK(new int[] { 10, 5, 2, 6 }, 100));
	}
}
