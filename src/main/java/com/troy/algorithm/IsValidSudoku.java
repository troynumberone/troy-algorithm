package com.troy.algorithm;

/**
 * @author: xuboru on 2018/10/17
 */
public class IsValidSudoku
{
	//static
	public boolean isValidSudoku(char[][] board)
	{
		int[][] row = new int[9][9];
		int[][] col = new int[9][9];
		int[][] block = new int[9][9];
		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				if (board[i][j] == '.')
					continue;
				int index = board[i][j] - '1';
				if (row[i][index] == 1)
				{
					return false;
				}
				else
				{
					row[i][index] = 1;
				}

				if (col[j][index] == 1)
				{
					return false;
				}
				else
				{
					col[j][index] = 1;
				}
				int x=i/3;
				int y=j/3;
				int blockIndex=x*3+y;
				if (block[blockIndex][index] == 1)
				{
					return false;
				}
				else
				{
					block[blockIndex][index] = 1;
				}
			}
		}
		return true;
	}

	public static void main(String[] args)
	{
		System.out.println('9' - '1');
	}
}
