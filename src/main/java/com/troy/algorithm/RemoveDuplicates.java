package com.troy.algorithm;

/**
 * @author: xuboru on 2018/12/4
 * 从排序数组中删除重复项
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/21/
 *
 */
public class RemoveDuplicates
{
	public int removeDuplicates(int[] nums)
	{
		if (nums == null || nums.length <= 0)
			return 0;
		int i = 0;
		for (int j = 1; j < nums.length; j++)
		{
			if (nums[j] != nums[i])
			{
				nums[++i] = nums[j];
			}
		}
		return i + 1;
	}
}
