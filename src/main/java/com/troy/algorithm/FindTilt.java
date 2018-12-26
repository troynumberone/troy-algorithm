package com.troy.algorithm;

/**
 * @author: xuboru on 2018/12/26
 * 二叉树的坡度
 * https://leetcode-cn.com/problems/binary-tree-tilt/
 */
public class FindTilt
{
	private int sum = 0;

	public int findTilt(TreeNode root)
	{
		sum(root);
		return sum;
	}

	private int sum(TreeNode root)
	{
		if (root == null)
			return 0;
		int left = sum(root.left);
		int right = sum(root.right);
		sum += Math.abs(right - left);
		return left + right + root.val;
	}
}
