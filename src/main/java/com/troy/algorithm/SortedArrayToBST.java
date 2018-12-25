package com.troy.algorithm;

/**
 * @author: xuboru on 2018/12/25\
 * 108. 将有序数组转换为二叉搜索树
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class SortedArrayToBST
{
	public TreeNode sortedArrayToBST(int[] nums)
	{
		if (nums == null)
			return null;
		return build(nums, 0, nums.length - 1);
	}

	private TreeNode build(int[] nums, int start, int end)
	{
		if (start > end)
			return null;
		if (start == end)
			return new TreeNode(nums[start]);
		int mid = (start + end) / 2;
		TreeNode node = new TreeNode(nums[mid]);
		node.left = build(nums, start, mid - 1);
		node.right = build(nums, mid + 1, end);
		return node;
	}
}
