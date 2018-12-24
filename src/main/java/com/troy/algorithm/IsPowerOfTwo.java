package com.troy.algorithm;

/**
 * @author: xuboru on 2018/12/24
 */
public class IsPowerOfTwo
{
	public boolean isPowerOfTwo(int n) {
		return  (n<=0) || (n&(n-1))!=0?false:true;
	}
}
