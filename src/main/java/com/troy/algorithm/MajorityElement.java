package com.troy.algorithm;

/**
 * @author: xuboru on 2018/12/24
 * 169. 求众数
 * https://leetcode-cn.com/problems/majority-element/
 */
public class MajorityElement
{
	/**
	 * 可以使用排序，map，本方法使用摩尔投票法
	 * 当前数假设为众数，下一个等于count+1，否者减一，为0者换假设的众数
	 * @param nums
	 * @return
	 */
	public int majorityElement(int[] nums)
	{
		int major = nums[0];
		int count = 1;
		for (int i = 1; i < nums.length; i++)
		{
			count = nums[i] != major ? count - 1 : count + 1;
			if (count == 0)
			{
				count++;
				major = nums[i];
			}
		}
		return major;
	}

	/**
	 * 位运算
	 * @param nums
	 * @return
	 */
	public int majorityElementBit(int[] nums)
	{
		int major=0;
		for (int i = 0, mask = 1; i < 32; i++, mask <<= 1)
		{
			int bit=0;
			for (int x:nums){
				if ((x&mask)==mask){
					bit++;
				}
				if (bit>nums.length/2){
					major|=mask;
					break;
				}
			}

		}
		return major;
	}
}
