package com.troy.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: xuboru on 2018/10/22
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

问总共有多少条不同的路径？



例如，上图是一个7 x 3 的网格。有多少可能的路径？

说明：m 和 n 的值均不超过 100。

示例 1:

输入: m = 3, n = 2
输出: 3
解释:
从左上角开始，总共有 3 条路径可以到达右下角。
1. 向右 -> 向右 -> 向下
2. 向右 -> 向下 -> 向右
3. 向下 -> 向右 -> 向右
示例 2:

输入: m = 7, n = 3
输出: 28


解题思路： 1深度优先 2数学上排列组合
 */
public class UniquePaths
{
	/**
	 * 数学解法
	 * @param m
	 * @param n
	 * @return
	 */
	public int uniquePathsNew(int m, int n)
	{
		if (m <= 0 || n <= 0)
			return 0;
		int rightStep = n - 1;
		int downStep = m - 1;
		int totalStep = rightStep + downStep;
		int maxStep = Math.max(rightStep, downStep);
		int minStep = totalStep - maxStep;
		long sum = 1;
		int j = 2;
		for (int i = maxStep + 1; i <= totalStep; i++)
		{
			sum *= i;
			while (j <= minStep && sum % j == 0)
			{
				sum /= j;
				j++;
			}
		}

		while (j <= minStep)
		{
			sum /= j;
			j++;
		}
		return Double.valueOf(sum).intValue();
	}

	static int[][] table = new int[][] { { 1, 0 }, { 0, 1 } };

	public int uniquePaths(int m, int n)
	{
		return dfs(0, 0, m, n);
	}

	int dfs(int i, int j, int m, int n)
	{
		int sum = 0;
		if (i == m - 1 && j == n - 1)
		{
			return 1;
		}

		for (int[] item : table)
		{
			int ni = i + item[0];
			int nj = j + item[1];
			if (ni >= 0 && ni < m && nj >= 0 && nj < n)
			{
				sum += dfs(ni, nj, m, n);
			}
		}
		return sum;
	}

	public static void main(String[] arg)
	{
		System.out.println(new UniquePaths().uniquePaths(3, 2));
		System.out.println(new UniquePaths().uniquePaths(7, 3));
		System.out.println(new UniquePaths().uniquePathsNew(3, 2));
		System.out.println(new UniquePaths().uniquePathsNew(7, 3));
	}
}
