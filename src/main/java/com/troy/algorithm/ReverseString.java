package com.troy.algorithm;

/**
 * @author: xuboru on 2018/10/25
 */
public class ReverseString
{
	public String reverseString(String s)
	{
		if (s == null)
			return null;
		StringBuilder r = new StringBuilder("");
		for (int i = s.length() - 1; i >= 0; i--)
		{
			r.append(s.charAt(i));
		}
		return r.toString();
	}

	public String reverseWords(String s)
	{
		if (s == null)
			return null;
		String[] ss = s.split(" ");
		StringBuilder r = new StringBuilder("");
		for (int i = 0; i < ss.length; i++)
		{
			r.append(reverseString(ss[i]));
			if (i != ss.length - 1)
			{
				r.append(" ");
			}

		}
		return r.toString();
	}
}
