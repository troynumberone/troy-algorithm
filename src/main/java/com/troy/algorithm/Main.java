package com.troy.algorithm;

import java.util.Scanner;

public class Main
{

	public int count(int[][] area, int r, int c)
	{
		int[][] size = new int[r][c];
		int max = 0;
		for (int i = 0; i < r; i++)
		{
			for (int j = 0; j < c; j++)
			{
				int re = getMax(area, size, r, c, i, j);
				if (re > max)
				{
					max = re;
				}
			}
		}
		return max;
	}

	private int getMax(int[][] area, int[][] size, int r, int c, int i, int j)
	{
		if (size[i][j] > 0)
		{
			return size[i][j];
		}
		int max = 1;
		if (i + 1 < r && area[i][j] > area[i + 1][j])
		{
			int tem = getMax(area, size, r, c, i + 1, j);
			if (tem + 1 > max)
			{
				max = tem + 1;
			}
		}

		if (j + 1 < c && area[i][j] > area[i][j + 1])
		{
			int tem = getMax(area, size, r, c, i, j + 1);
			if (tem + 1 > max)
			{
				max = tem + 1;
			}
		}
		if (i - 1 >= 0 && area[i][j] > area[i - 1][j])
		{
			int tem = getMax(area, size, r, c, i - 1, j);
			if (tem + 1 > max)
			{
				max = tem + 1;
			}
		}
		if (j - 1 >= 0 && area[i][j] > area[i][j - 1])
		{
			int tem = getMax(area, size, r, c, i, j - 1);
			if (tem + 1 > max)
			{
				max = tem + 1;
			}
		}
		size[i][j] = max;
		return max;
	}

	public static void main(String args[]) throws Exception
	{
		Scanner cin = new Scanner(System.in);
		int a = cin.nextInt();
		int b = cin.nextInt();
		int[][] area = new int[a][b];
		for (int i = 0; i < a; i++)
		{
			for (int j = 0; j < b; j++)
			{
				if (cin.hasNext()) {
					area[i][j] = cin.nextInt();
				}
			}
		}
		Main skiing = new Main();
		System.out.println(skiing.count(area, a, b));
		cin.close();
	}
}
