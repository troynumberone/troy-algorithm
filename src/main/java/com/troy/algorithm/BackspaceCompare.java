package com.troy.algorithm;

import java.util.Stack;

/**
 * @author: xuboru on 2018/12/20
 */
public class BackspaceCompare
{
	public boolean backspaceCompare(String S, String T)
	{
		Stack<Character> stackS = new Stack<>();
		Stack<Character> stackT = new Stack<>();
		for (char c : S.toCharArray())
		{
			if (c == '#')
			{
				if (!stackS.isEmpty())
					stackS.pop();
			}
			else
			{
				stackS.push(c);
			}
		}

		for (char c : T.toCharArray())
		{
			if (c == '#')
			{
				if (!stackT.isEmpty())
					stackT.pop();
			}
			else
			{
				stackT.push(c);
			}
		}

		if (stackS.size() != stackT.size())
			return false;
		while (!stackS.isEmpty())
		{
			if (stackS.pop() != stackT.pop())
				return false;
		}
		return true;
	}
}
