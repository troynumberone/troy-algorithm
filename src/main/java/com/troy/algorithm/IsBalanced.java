package com.troy.algorithm;

/**
 * @author: xuboru on 2018/12/26
 * 110. 平衡二叉树
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 */
public class IsBalanced
{
	public boolean isBalanced(TreeNode root)
	{
		return high(root) != -1;
	}

	private int high(TreeNode root)
	{
		if (root == null)
			return 0;
		int left = high(root.left);
		if (left == -1)
			return -1;
		int right = high(root.right);
		if (right == -1)
			return -1;
		if (Math.abs(right - left) > 1)
		{
			return -1;
		}
		return 1 + Math.max(left, right);
	}
}
