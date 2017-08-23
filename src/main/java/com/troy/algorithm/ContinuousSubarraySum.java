package com.troy.algorithm;

/**
 * Given a list of non-negative numbers and a target integer k, write a function to check if the array has a continuous subarray of size at least 2 that sums up to the multiple of k, that is, sums up to n*k where n is also an integer.

 Example 1:
 Input: [23, 2, 4, 6, 7],  k=6
 Output: True
 Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
 Example 2:
 Input: [23, 2, 6, 4, 7],  k=6
 Output: True
 Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
 Note:
 The length of the array won't exceed 10,000.
 You may assume the sum of all the numbers is in the range of a signed 32-bit integer.
 */
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
