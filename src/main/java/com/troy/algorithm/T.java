package com.troy.algorithm;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author: xuboru on 2018/7/6
 */
public class T
{
	private static ThreadLocalRandom random=ThreadLocalRandom.current();

	/*private static ThreadLocal<Integer> in=new ThreadLocal<Integer>();

	static {
		in.set(1);
	}*/

	/*static {
		random.setSeed();
	}*/

	public static void main(String[] args){
		new Thread(()->{
			System.out.println(Thread.currentThread());
			System.out.println(random.nextInt());
		}).start();
		new Thread(()->{
			System.out.println(Thread.currentThread());
			System.out.println(random.nextInt());
		}).start();
		new Thread(()->{
			System.out.println(Thread.currentThread());
			System.out.println(random.nextInt());
		}).start();
	}
}
