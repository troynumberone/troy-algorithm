package com.troy.algorithm;

/**
 * @author: xuboru on 2018/12/24
 */
public class MissingNumber
{
	public int missingNumber(int[] nums) {
		int sum=0;
		for (int i = 0; i < nums.length; i++)
		{
			sum^=i+1;
			sum^=nums[i];
		}
		return sum;
	}
}
