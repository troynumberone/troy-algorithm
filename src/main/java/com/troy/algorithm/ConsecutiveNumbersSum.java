package com.troy.algorithm;

/**
 * @author: xuboru on 2018/5/11
 *
 * 超时
 */
public class ConsecutiveNumbersSum
{
	public int consecutiveNumbersSum(int n)
	{
		long[] s = new long[n + 1];
		for (int i = 1; i <= n; i++)
		{
			s[i] = s[i - 1] + i;
		}
		long[] d = new long[n + 1];
		for (int i = 0; i <= n; i++)
		{
			d[i] = s[i] + n;
		}
		int i = 0;
		int j = 0;
		int count=0;
		while (i<=n&&j<=n)
		{
			//System.out.println(s[j]+"="+d[i]);
			if (s[j]==d[i]){
				count++;
				i++;
				j++;
			}else if(s[j]<d[i]){
				j++;
			}else {
				i++;
			}
		}
		return count;
	}

	public static void main(String[] arg)
	{
		ConsecutiveNumbersSum consecutiveNumbersSum = new ConsecutiveNumbersSum();
		for (int i=0;i<20;i++){
			System.out.println(consecutiveNumbersSum.consecutiveNumbersSum(i));
		}


	}
}
