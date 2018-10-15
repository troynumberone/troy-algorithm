package com.troy.algorithm;

/**
 * @author: xuboru on 2018/10/15
 * 将字符串 "PAYPALISHIRING" 以Z字形排列成给定的行数：

P   A   H   N
A P L S I I G
Y   I   R
之后从左往右，逐行读取字符："PAHNAPLSIIGYIR"

实现一个将字符串进行指定行数变换的函数:

string convert(string s, int numRows);
示例 1:

输入: s = "PAYPALISHIRING", numRows = 3
输出: "PAHNAPLSIIGYIR"
示例 2:

输入: s = "PAYPALISHIRING", numRows = 4
输出: "PINALSIGYAHRPI"
解释:

P     I    N
A   L S  I G
Y A   H R
P     I
 */
public class Zconvert
{
	public String convert(String s, int numRows)
	{
		if (s == null || s.length() == 0 || numRows < 1)
		{
			return null;
		}
		if (numRows==1)
			return s;
		StringBuilder[] stringBuilders=new StringBuilder[numRows];
		for (StringBuilder stringBuilder:stringBuilders)
		{
			stringBuilder=new StringBuilder("");
		}
		int n=numRows*2-2;
		for (int j=0;j<s.length();j+=n){
			for (int i=0;i<n;i++){
				if (j+i>=s.length()){
					break;
				}
				if (i+1>numRows){
					stringBuilders[2*numRows-2-i].append(s.charAt(i+j));
				}else {
					stringBuilders[i].append(s.charAt(i+j));
				}
			}
		}
		StringBuilder to=new StringBuilder("");
		for (int i=0;i<numRows;i++){
			to.append(stringBuilders[i]);
		}
		return to.toString();
	}
}
