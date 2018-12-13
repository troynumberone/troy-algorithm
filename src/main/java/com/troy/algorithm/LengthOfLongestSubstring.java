package com.troy.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: xuboru on 2018/10/15
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。

示例 1:

输入: "abcabcbb"
输出: 3
解释: 无重复字符的最长子串是 "abc"，其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 无重复字符的最长子串是 "b"，其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 无重复字符的最长子串是 "wke"，其长度为 3。
请注意，答案必须是一个子串，"pwke" 是一个子序列 而不是子串。
 */
public class LengthOfLongestSubstring
{

	public int lengthOfLongestSubstring(String s)
	{
		int max = 0;
		if (s == null || s.length() == 0)
			return max;
		Map<Character, Integer> map = new HashMap<>();
		char[] chars = s.toCharArray();
		max = 1;
		map.put(chars[0], 0);
		for (int i = 0, j = 1; (s.length() - i) > max && j < s.length(); j++)
		{
			Integer indexi = map.get(chars[j]);
			if (indexi == null)
			{
				int le = j - i + 1;
				if (le > max)
					max = le;
			}
			else
			{
				for (int re = i; re < indexi; re++)
					map.remove(chars[re]);
				i = indexi + 1;
			}
			map.put(chars[j], j);
		}
		return max;
	}
}
