package com.troy.algorithm;

/**
 * @author: xuboru on 2018/6/2
 * 我们有一系列公交路线。每一条路线 routes[i] 上都有一辆公交车在上面循环行驶。
 * 例如，有一条路线 routes[0] = [1, 5, 7]，表示第一辆 (下标为0)
 * 公交车会一直按照 1->5->7->1->5->7->1->... 的车站路线行驶。
 * 假设我们从 S 车站开始（初始时不在公交车上），要去往 T 站。
 * 期间仅可乘坐公交车，求出最少乘坐的公交车数量。返回 -1 表示不可能到达终点车站。
 * 说明:
 * 1 <= routes.length <= 500.
 * 1 <= routes[i].length <= 500.
 * 0 <= routes[i][j] < 10 ^ 6.
 */
public class NumBusesToDestination
{
	public int numBusesToDestination(int[][] routes, int S, int T)
	{
		int[][] num = new int[100][100];
		int busNumber = routes.length;
		int busSite = routes[0].length;
		for (int i = 0; i < busNumber; i++)
		{
			for (int j = 0; j < busSite; j++)
			{
				for (int x = j + 1; x < busSite; x++)
				{
					int site1 = routes[i][j];
					int site2 = routes[i][x];
					num[site1][site2] = 1;
					num[site2][site1] = 1;
				}
			}
		}
		return numBusesToDestination(num,S,T);
	}

	public static void main(String[] arg){
		String m="delete from tb_wallet_change where account_id=";
		for (long i=9000000100L;i<=9000000999L;i++){
			System.out.println(m+"\""+i+"\""+";");
		}
	}

	public int numBusesToDestination2(int[][] num, int s, int t)
	{
		if (num[s - 1][t - 1] != 0)
		{
			return num[s - 1][t - 1];
		}
		else
		{
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < 100; i++)
			{
				if (num[s - 1][i] > 0)
				{
					int n = numBusesToDestination(num, i + 1, t);
					if (n > 0 && n + 1 < min)
					{
						min = n + 1;
					}
				}
			}
			if (min < Integer.MAX_VALUE){
				num[s-1][t-1]=min;
				num[t-1][s-1]=min;
				return min;
			}else {
				return -1;
			}
		}
	}

	/*public static void main(String[] args){
		int[][] routes = new int[][]{{1, 2, 7}, {3, 6, 7}};
		NumBusesToDestination numBusesToDestination=new NumBusesToDestination();
		System.out.println(numBusesToDestination
				.numBusesToDestination(routes,1,6));

	}*/
}
