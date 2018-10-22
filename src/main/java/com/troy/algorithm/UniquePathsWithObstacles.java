package com.troy.algorithm;

/**
 * @author: xuboru on 2018/10/22
 */
public class UniquePathsWithObstacles
{
	static int[][] table = new int[][] { { 1, 0 }, { 0, 1 } };

	public int uniquePathsWithObstacles(int[][] obstacleGrid)
	{
		if (obstacleGrid == null || obstacleGrid.length <= 0 || obstacleGrid[0].length <= 0)
			return 0;
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[] dp = new int[m * n];
		if (obstacleGrid[m - 1][n - 1] == 1)
			return 0;
		dp[m * n - 1] = 1;
		for (int i = m - 1; i >= 0; i--)
		{
			for (int j = n - 1; j >= 0; j--)
			{
				if (obstacleGrid[i][j] == 1)
					continue;
				for (int[] item : table)
				{
					int ni = i + item[0];
					int nj = j + item[1];
					if (ni >= 0 && ni < m && nj >= 0 && nj < n)
					{
						int index = i * n + j;
						int indexN = ni * n + nj;
						dp[index] += dp[indexN];
					}
				}
			}
		}
		return dp[0];
	}

	public static void main(String[] arg)
	{
		System.out.println(new UniquePathsWithObstacles().uniquePathsWithObstacles(
				new int[][] { { 0, 0, 0 },
						{ 0, 1, 0 },
						{ 0, 0, 0 } }));

	}
}
