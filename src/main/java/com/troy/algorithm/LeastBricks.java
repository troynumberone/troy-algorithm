package com.troy.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: xuboru on 2018/10/11
 * 你的面前有一堵方形的、由多行砖块组成的砖墙。 这些砖块高度相同但是宽度不同。你现在要画一条自顶向下的、穿过最少砖块的垂线。

砖墙由行的列表表示。 每一行都是一个代表从左至右每块砖的宽度的整数列表。

如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。你需要找出怎样画才能使这条线穿过的砖块数量最少，并且返回穿过的砖块数量。

你不能沿着墙的两个垂直边缘之一画线，这样显然是没有穿过一块砖的。



示例：

输入:
[[1,2,2,1],
[3,1,2],
[1,3,2],
[2,4],
[3,1,2],
[1,3,1,1]]
输出: 2
解释:
src\resources\brick_wall.png

提示：

每一行砖块的宽度之和应该相等，并且不能超过 INT_MAX。
每一行砖块的数量在 [1,10,000] 范围内， 墙的高度在 [1,10,000] 范围内， 总的砖块数量不超过 20,000。
 */
public class LeastBricks
{
	public int leastBricks(List<List<Integer>> wall)
	{
		if (wall == null || wall.size() == 0 || wall.get(0).size() == 0)
			return 0;
		Map<Integer, Integer> map = new HashMap<>();
		int max = 0;
		for (List<Integer> list : wall)
		{
			int sum = 0;
			for (int i = 0; i < list.size() - 1; i++)
			{
				sum += list.get(i);
				int count = map.merge(sum, 1, (x, y) -> x + y);
				if (count > max)
				{
					max = count;
				}
			}

		}
		return wall.size() - max;
	}

	public static void main(String[] args)
	{
		System.out.println(new LeastBricks().leastBricks(
				Arrays.asList(Arrays.asList(6), Arrays.asList(6), Arrays.asList(2, 4), Arrays.asList(6),
						Arrays.asList(1, 2, 2, 1), Arrays.asList(6), Arrays.asList(2, 1, 2, 1), Arrays.asList(1, 5),
						Arrays.asList(4, 1, 1), Arrays.asList(1, 4, 1), Arrays.asList(4, 2), Arrays.asList(3, 3),
						Arrays.asList(2, 2, 2), Arrays.asList(5, 1), Arrays.asList(5, 1), Arrays.asList(6),
						Arrays.asList(4, 2), Arrays.asList(1, 5), Arrays.asList(2, 3, 1), Arrays.asList(4, 2),
						Arrays.asList(1, 1, 4), Arrays.asList(1, 3, 1, 1), Arrays.asList(2, 3, 1), Arrays.asList(3, 3),
						Arrays.asList(3, 1, 1, 1), Arrays.asList(3, 2, 1), Arrays.asList(6), Arrays.asList(3, 2, 1),
						Arrays.asList(1, 5), Arrays.asList(1, 4, 1))

		));

	}
}
