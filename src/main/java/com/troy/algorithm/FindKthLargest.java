package com.troy.algorithm;

import java.util.Arrays;

/**
 * @author: xuboru on 2018/11/30
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

示例 1:

输入: [3,2,1,5,6,4] 和 k = 2
输出: 5
示例 2:

输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4
说明:

你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */
public class FindKthLargest
{
	public int findKthLargest(int[] nums, int k)
	{
		//初始化堆,最小堆
		init(nums, k);
		for (int i = k; i < nums.length; i++)
		{
			if (nums[i] > nums[0])
			{
				int tem = nums[i];
				nums[i] = nums[0];
				nums[0] = tem;
				//调整堆
				minHeapSort(nums, 0, k);
			}
		}
		return nums[0];
	}

	private void init(int[] nums, int k)
	{
		for (int i = (k - 1) / 2; i >= 0; i--)
		{
			minHeapSort(nums, i, k);
		}
	}

	private void minHeapSort(int[] nums, int index, int size)
	{
		int left = index * 2;
		int right = index * 2 + 1;
		int minIndex = index;
		if (left < size && nums[left] < nums[minIndex])
			minIndex = left;
		if (right < size && nums[right] < nums[minIndex])
			minIndex = right;
		if (minIndex != index)
		{
			swap(nums, minIndex, index);
			minHeapSort(nums, minIndex, size);
		}
	}

	private void swap(int[] nums, int a, int b)
	{
		nums[a] = nums[a] ^ nums[b];
		nums[b] = nums[a] ^ nums[b];
		nums[a] = nums[a] ^ nums[b];
	}

	public static void main(String[] args)
	{
		int[] a = new int[] { 3, 2, 1, 5, 6, 4 };
		System.out.println(new FindKthLargest().findKthLargest(a, 2));
		a = new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
		System.out.println(new FindKthLargest().findKthLargest(a, 4));
	}
}
