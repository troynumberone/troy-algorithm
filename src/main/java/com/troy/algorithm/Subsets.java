package com.troy.algorithm;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xuboru on 2018/12/24
 */
public class Subsets
{
	public List<List<Integer>> subsets(int[] nums)
	{
		List<List<Integer>> re = new ArrayList<>();
		int n = nums == null ? 0 : nums.length;
		for (int i = 0; i < 1 << n; i++)
		{
			List<Integer> list = new ArrayList<>();
			for (int j = 0; j < n; j++)
			{
				if ((i&(1<<j))==0){
					list.add(nums[j]);
				}
			}
			re.add(list);
		}
		return re;
	}

	public static void main(String[] args){
		System.out.println(1<<0);
	}
}
