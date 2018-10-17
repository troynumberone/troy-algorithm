package com.troy.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xuboru on 2018/10/16
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 示例:
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */
public class LetterCombinations
{
//	static char[][] table=new char[][]{{'a','b','c'},
//			{'d','e','f'},
//			{'g','h','i'},
//			{'j','k','l'},
//			{'m','n','o'},
//			{'p','q','i'},
//			{'s','t','u'},
//			{'v','w',}}
	public List<String> letterCombinations(String digits)
	{
		List<String> list = new ArrayList<>();
		if (digits == null || digits.length() == 0)
			return list;
		int n = digits.length();
		int sum = 1;
		for (int i = 0; i < n; i++)
			sum *= 3;
		String[] result = new String[sum];
		for (int i = 0; i < n - 1; i++)
		{

		}
		return null;//todo
	}
}
