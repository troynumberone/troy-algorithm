package com.troy.other;

import java.util.ArrayList;

/**
 * @author: xuboru on 2018/5/30
 */
public class StaticTest
{
	public static void main(String[] args) throws Exception
	{
		/** 初始化集合类*/
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < 100; i++)
		{
			list.add(i + "");
		}
		new Thread(()->{
			try
			{
				Thread.sleep(2000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			list.add("100");
			System.out.println("remove"+5);
		}).start();

		/** 遍历时删除元素*/
		for (String obj : list)
		{
			Thread.sleep(1000);
			System.out.println(obj);
		}





	}
}
