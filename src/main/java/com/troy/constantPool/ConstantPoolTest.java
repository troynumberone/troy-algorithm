package com.troy.constantPool;

/**
 * @author: xuboru on 2018/12/7
 */
public class ConstantPoolTest
{
	//java -D java.lang.Integer.IntegerCache.high=1000
	//java -XX:AutoBoxCacheMax=1000 TestAutoBoxCache
	public static void main(String[] args)
	{
		Integer i = 128;//java的自动装箱，等于Integer.valueOf(127)
		Integer j = 128;//total.intValue();
		Integer m = 127;
		Integer k = 127;
		System.out.println(i == j);//false 修改High值后为true
		System.out.println(m == k);//true
	}
}
