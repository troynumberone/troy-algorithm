package com.troy.algorithm;

/**
 * 字符串的排列
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * 示例1:
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * 示例2:
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 * 注意：输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 * @author: xuboru on 2018/12/13
 */
public class CheckInclusion
{
	public boolean checkInclusion(String s1, String s2)
	{
		int s1l, s2l;
		if ((s2l = s2.length()) < (s1l = s1.length()))
			return false;
		long s1v = 0;
		long s2v = 0;
		for (int i = 0; i < s1l; i++)
		{
			s1v += 1 << (s1.charAt(i) - 'a');
			s2v += 1 << (s2.charAt(i) - 'a');
		}
		int i = 0, j = s1l - 1;
		while (j < s2l)
		{
			if (s2v == s1v)
				return true;
			else
			{
				s2v -= 1 << (s2.charAt(i) - 'a');
				i++;
				j++;
				if (j < s2l)
					s2v += 1 << (s2.charAt(j) - 'a');
			}
		}
		return false;
	}

	public static void main(String[] args)
	{
		System.out.println(new CheckInclusion().checkInclusion("ab", "eidbaooo"));
	}
}
