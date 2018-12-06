package com.troy.algorithm;

/**
 * @author: xuboru on 2018/12/6
 */
public class MaxAreaOfIsland
{
	private int[][] direction = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public int maxAreaOfIsland(int[][] grid)
	{
		if (grid == null || grid.length <= 0 || grid[0].length <= 0)
			return 0;
		int max = 0;
		int row = grid.length;
		int col = grid[0].length;
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < col; j++)
			{
				int temp = findMax(grid, i, j, row, col);
				if (temp > max)
					max = temp;
			}
		}
		return max;
	}

	private int findMax(int[][] grid, int i, int j, int row, int col)
	{
		if (grid[i][j] == 0)
			return 0;
		grid[i][j] = 0;
		int count = 1;
		for (int[] item : direction)
		{
			int newI = i + item[0];
			int newJ = j + item[1];
			if (newI >= 0 && newI < row && newJ >= 0 && newJ < col)
			{
				count += findMax(grid, newI, newJ, row, col);
			}
		}
		return count;
	}
}
