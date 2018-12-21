package com.troy.algorithm;

/**
 * @author: xuboru on 2018/12/21
 * 476. 数字的补数
 * https://leetcode-cn.com/problems/number-complement/\
 * 使用hashMap源码计算2的幂次方的算法
 */
public class FindComplement
{
	public int findComplement(int num) {
		int x=num;
		x|=x>>>1;
		x|=x>>>2;
		x|=x>>>4;
		x|=x>>>8;
		x|=x>>>16;
		return num^x;
	}
}
