package com.troy.algorithm;

/**
 * @author: xuboru on 2018/10/16
 * 编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
说明:

所有输入只包含小写字母 a-z 。

在真实的面试中遇到过这道题？
 */
public class LongestCommonPrefix
{
	public String longestCommonPrefix(String[] strs)
	{
		if (strs == null || strs.length == 0)
		{
			return "";
		}
		if (strs.length == 1)
			return strs[0];
		StringBuilder stringBuilder = new StringBuilder();
		int minLength = Integer.MAX_VALUE;
		int n = strs.length;
		for (String item : strs)
		{
			if (item == null)
				minLength = 0;
			else
				minLength = item.length() < minLength ? item.length() : minLength;
		}
		for (int i = 0; i < minLength; i++)
		{
			Character c = strs[0].charAt(i);
			for (int j = 1; j < n; j++)
			{
				if (c != strs[j].charAt(i))
					return stringBuilder.toString();
			}
			stringBuilder.append(c);
		}
		return stringBuilder.toString();
	}
}
