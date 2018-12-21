package com.troy.algorithm;

/**
 * @author: xuboru on 2018/12/21
 * 136. 只出现一次的数字
 * https://leetcode-cn.com/problems/single-number/
 */
public class SingleNumber
{
	public int singleNumber(int[] nums) {
		int sum=0;
		for (int s:nums) sum^=s;
		return sum;
	}
}
