package com.troy.algorithm;

/**
 * @author: xuboru on 2018/12/24
 * 389. 找不同
 * https://leetcode-cn.com/problems/find-the-difference/
 * 与找不重复的算法一致
 */
public class FindTheDifference
{
	public char findTheDifference(String s, String t)
	{
		int resultInt = 0;
		for (int i = 0; i < s.length(); i++)
		{
			resultInt ^= s.charAt(i) - 'a';
		}
		for (int i = 0; i < t.length(); i++)
		{
			resultInt ^= t.charAt(i) - 'a';
		}
		return (char) ('a' + resultInt);
	}
}
