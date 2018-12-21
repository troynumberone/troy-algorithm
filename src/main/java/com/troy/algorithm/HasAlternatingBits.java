package com.troy.algorithm;

/**
 * @author: xuboru on 2018/12/21
 */
public class HasAlternatingBits
{
	public boolean hasAlternatingBits(int n) {
		int temp=n^(n>>1);
		return (temp&(temp+1))==0;
	}
}
