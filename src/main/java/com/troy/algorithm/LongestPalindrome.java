package com.troy.algorithm;

import java.util.Arrays;

/**
 * @author: xuboru on 2018/12/17
 *	动态规划
 * 	Manacher算法
 */
public class LongestPalindrome
{
	//动态规划
	public String longestPalindrome(String s)
	{
		if (s == null || s.length() == 0)
			return "";
		int max = 0;
		int maxi = -1;
		int n = s.length();
		char[] chars = s.toCharArray();
		boolean[][] dp = new boolean[n][n];
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j <= i; j++)
			{
				if (i - j < 2)
				{
					dp[j][i] = chars[i] == chars[j];
				}
				else
				{
					dp[j][i] = dp[j + 1][i - 1] && chars[i] == chars[j];
				}
				if (dp[j][i] && i - j + 1 > max)
				{
					max = i - j + 1;
					maxi = j;
				}
			}
		}
		return s.substring(maxi, maxi + max);
	}

	public static void main(String[] arg)
	{
		System.out.println(new LongestPalindrome().longestPalindrome("abcda"));
	}

}
