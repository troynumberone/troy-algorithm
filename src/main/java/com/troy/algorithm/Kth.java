package com.troy.algorithm;

/**
 * @author: xuboru on 2018/5/11
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 * 说明：
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 */
public class Kth
{
	public String getPermutation(int n, int k) {
		String m="";
		int s=(1<<n)-1;
		int factorial=1;
		for (int i=2;i<=n;i++){
			factorial*=i;
		}
		int x=n;
		while (x>0){
			factorial=factorial/x;
			x--;
			int po=k%factorial==0?k/factorial-1:k/factorial;
			if (po<0){
				po=0;
			}
			int j=0;
			for (int i=0;i<n;i++){
				if ((s&1<<i)>0){
					if (j==po){
						s=s^(1<<i);
						m+=(i+1);
						break;
					}
					j++;
				}
			}
			k=k-factorial*po;
		}
		return m;
	}


	public static void main(String[] arg){
		Kth kth=new Kth();
		System.out.println(kth.getPermutation(2,2));
	}
}
