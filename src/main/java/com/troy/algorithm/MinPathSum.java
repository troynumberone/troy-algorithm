package com.troy.algorithm;

/**
 * @author: xuboru on 2018/10/22
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。

示例:

输入:
[
[1,3,1],
[1,5,1],
[4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class MinPathSum
{
	public int minPathSum(int[][] grid)
	{
		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;
		int m = grid.length;
		int n = grid[0].length;
		int[][] dp = new int[m][n];
		dp[0][0] = grid[0][0];
		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (i == 0 && j == 0)
					continue;
				int min = Integer.MAX_VALUE;
				if (i - 1 >= 0)
				{
					int t = dp[i - 1][j] + grid[i][j];
					if (t < min)
						min = t;
				}
				if (j - 1 >= 0)
				{
					int t = dp[i][j - 1] + grid[i][j];
					if (t < min)
						min = t;
				}
				dp[i][j] = min;
			}
		}
		return dp[m - 1][n - 1];
	}

	public static void main(String[] arg){
		System.out.println(new MinPathSum().minPathSum(new int[][]{{1,3,1}
		,{1,5,1},{4,2,1}}));
	}
}
