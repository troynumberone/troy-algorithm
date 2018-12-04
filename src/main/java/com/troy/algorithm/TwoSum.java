package com.troy.algorithm;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author: xuboru on 2018/10/12
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。

你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
 */
public class TwoSum
{
	public int[] twoSumMapSolution(int[] nums, int target)
	{
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++)
		{
			int temp = target - nums[i];
			if (map.containsKey(temp))
				return new int[] { map.get(temp), i };
			else
				map.put(nums[i], i);
		}
		return null;
	}

	public int[] twoSum(int[] nums, int target)
	{
		if (nums != null && nums.length != 0)
		{
			List<int[]> list = new ArrayList<>();
			for (int m = 0; m < nums.length; m++)
			{
				list.add(new int[] { nums[m], m });
			}

			list.sort(Comparator.comparing(x -> x[0]));
			int i = 0, j = list.size() - 1;
			while (i < j)
			{
				int compare = list.get(i)[0] + list.get(j)[0];
				if (compare == target)
				{
					int r1 = list.get(i)[1];
					int r2 = list.get(j)[1];
					if (r1 < r2)
						return new int[] { r1, r2 };
					else
						return new int[] { r2, r1 };
				}
				else if (compare > target)
				{
					j--;
				}
				else
				{
					i++;
				}
			}

		}
		return new int[] {};
	}

}
