package com.troy.algorithm;

/**
 * @author: xuboru on 2018/12/17
 */
public class NumArray
{
	private int[] sum;

	public NumArray(int[] nums)
	{
		if (nums == null || nums.length <= 0)
			return;
		sum = new int[nums.length + 1];
		sum[0] = 0;
		for (int i = 0; i < nums.length; i++)
		{
			sum[i + 1] = sum[i] + nums[i];
		}

	}

	public int sumRange(int i, int j)
	{
		if (sum == null)
			return 0;
		return sum[j + 1] - sum[i];
	}
}
