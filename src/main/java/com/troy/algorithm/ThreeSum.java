package com.troy.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author: xuboru on 2018/10/12
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
[-1, 0, 1],
[-1, -1, 2]
]
 */
public class ThreeSum
{
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList();
		Arrays.sort(nums);
		for(int k=0;k<nums.length;k++){
			int i = k+1,j = nums.length - 1;//***
			while(i < j){
				int value = nums[i] + nums[j];
				if(value == (-nums[k])){
					List<Integer> list = new ArrayList();
					list.add(nums[k]);
					list.add(nums[i]);
					list.add(nums[j]);
					res.add(list);
					//重值处理
					//****一定要有i < j条件，否则i会到最后
					while(i<j && nums[i] == nums[i+1]){
						i++;
					}
					//****一定要有i < j条件，否则j会取-1
					while(i<j && nums[j] == nums[j-1]){
						j--;
					}
					//***
					i++;
					j--;
				}
				else if(value < (-nums[k]))
					i++;
				else
					j--;
			}
			//****重值处理
			while(k < nums.length-1 && nums[k] == nums[k+1]){
				k++;
			}
		}
		return res;
	}


	public static void main(String[] args)
	{
		System.out.println(new ThreeSum().threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
	}
}
