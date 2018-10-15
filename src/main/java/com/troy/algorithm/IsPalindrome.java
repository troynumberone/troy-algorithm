package com.troy.algorithm;

/**
 * @author: xuboru on 2018/10/15
 */
public class IsPalindrome
{
	public boolean isPalindrome(int x)
	{
		if (x < 0)
			return false;
		if (x < 10)
			return true;
		String s = String.valueOf(x);
		for (int i = 0, j = s.length() - 1; i < j; i++, j--)
		{
			if (s.charAt(i) != s.charAt(j))
				return false;
		}
		return true;
	}

	public static void main(String[] args)
	{
		System.out.println(new IsPalindrome().isPalindrome(10));
	}
}
