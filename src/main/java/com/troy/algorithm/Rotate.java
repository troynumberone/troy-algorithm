package com.troy.algorithm;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author: xuboru on 2018/10/17
 */
public class Rotate
{
	static int[][] t = new int[][] { { 1, -1 }, { 1, -1 }, { 1, -1 }, { 1, -1 } };

	public void rotate(int[][] matrix)
	{
		if (matrix == null || matrix.length == 0 || matrix[0].length <= 1)
			return;
		int n = matrix.length;
		Double half = n * 1.0 / 2 - 1;
		Double yd = (n - 1) * 1.0 / 2;
		for (int i = 0; i <= half; i++)
		{
			for (int j = 0; j <= half; j++)
			{
				int temp2;
				int nextI = i;
				int nextJ = j;
				int temp = matrix[nextI][nextJ];
				for (int c = 0; c < 4; c++)
				{
					System.out.println("ninjP" + nextI + "-" + nextJ + "-" + yd);
					nextI = Double.valueOf((nextJ - yd) + yd).intValue();
					nextJ = Double.valueOf(yd - (nextI - yd)).intValue();
					System.out.println("ninjA" + nextI + "-" + nextJ);
					temp2 = matrix[nextI][nextJ];
					matrix[nextI][nextJ] = temp;
					temp = temp2;
				}
			}
		}

		if (n % 2 != 0)
		{
			int m = n / 2;
			for (int i = 0; i < m; i++)
			{
				int temp2;
				int nextI = i;
				int nextJ = m;
				int temp = matrix[nextI][nextJ];
				for (int[] item : t)
				{
					System.out.println("ninjP" + nextI + "-" + nextJ);
					nextI = Double.valueOf((nextI - half) * item[0] + half).intValue();
					nextJ = Double.valueOf((nextJ - half) * item[1] + half).intValue();
					System.out.println("ninjA" + nextI + "-" + nextJ);
					temp2 = matrix[nextI][nextJ];
					matrix[nextI][nextJ] = temp;
					temp = temp2;
				}
			}
		}

	}

	public static void main(String[] arg)
	{
		int[][] ma = new int[][] {
				{ 5, 1, 9, 11 },
				{ 2, 4, 8, 10 },
				{ 13, 3, 6, 7 },
				{ 15, 14, 12, 16 }
		};
		new Rotate().rotate(ma);
		System.out.println(Arrays.deepToString(ma));
	}
}
