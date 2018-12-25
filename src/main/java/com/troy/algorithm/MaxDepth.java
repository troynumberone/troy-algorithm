package com.troy.algorithm;

import com.troy.algorithm.TreeNode;

/**
 * @author: xuboru on 2018/12/25
 * 104. 二叉树的最大深度
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class MaxDepth
{
	public int maxDepth(TreeNode root)
	{
		return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}
}
