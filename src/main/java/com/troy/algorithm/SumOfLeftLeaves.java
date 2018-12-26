package com.troy.algorithm;

/**
 * @author: xuboru on 2018/12/26
 * 404. 左叶子之和
 * https://leetcode-cn.com/problems/sum-of-left-leaves/
 */
public class SumOfLeftLeaves
{
	private int sum = 0;

	public int sumOfLeftLeaves(TreeNode root)
	{
		sumOfLeftLeaves(root, false);
		return sum;
	}

	private void sumOfLeftLeaves(TreeNode root, boolean left)
	{
		if (root == null)
			return;
		if (root.left == null && root.right == null)
		{
			if (left)
				sum += root.val;
			else
				return;
		}
		else
		{
			sumOfLeftLeaves(root.left, true);
			sumOfLeftLeaves(root.right, false);
		}
	}
}
