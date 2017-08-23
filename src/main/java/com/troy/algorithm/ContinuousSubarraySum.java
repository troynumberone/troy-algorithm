package com.troy.algorithm;

public class ContinuousSubarraySum
{
	public boolean checkSubarraySum(int[] nums, int k)
	{
		if (nums == null || nums.length == 0)
		{
			return false;
		}
		long[] sum = new long[nums.length + 1];
		for (int i = 1; i < sum.length; i++)
		{
			sum[i] = sum[i - 1] + nums[i - 1];
		}
		for (int i = 0; i < sum.length; i++)
		{
			for (int j = i + 2; j < sum.length; j++)
			{
				if (k == 0)
				{
					if (sum[j] - sum[i] == 0)
					{
						return true;
					}
				}
				else
				{
					if ((sum[j] - sum[i]) % k == 0)
					{
						return true;
					}
				}
			}
		}
		return false;
	}

	public static void main(String[] args)
	{
		ContinuousSubarraySum continuousSubarraySum = new ContinuousSubarraySum();
		System.out.println(
				continuousSubarraySum.checkSubarraySum(new int[] { 23, 2, 4, 6, 7 }, 6));
	}
}
