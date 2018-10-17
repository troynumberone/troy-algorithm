package com.troy.algorithm;

import java.util.Stack;

/**
 * @author: xuboru on 2018/10/17
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true
 */
public class IsValid
{
	static char[] left = new char[] { '[', '{', '(' };
	static char[] right = new char[] { ']', '}', ')' };

	public boolean isValid(String s)
	{
		if (s == null || s.length() == 0)
			return true;
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++)
		{
			char c = s.charAt(i);
			if (c == ' ')
			{
				continue;
			}
			for (int j = 0; j < 3; j++)
			{
				if (c == left[j])
				{
					stack.push(c);
					break;
				}
			}
			for (int j = 0; j < 3; j++)
			{
				if (c == right[j])
				{
					if (stack.empty())
					{
						return false;
					}
					else
					{
						char popItem=stack.pop();
						if (popItem == left[j])
							break;
						else
							return false;
					}
				}
			}
		}
		return stack.empty();
	}
}
