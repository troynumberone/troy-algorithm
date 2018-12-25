package com.troy.algorithm;

/**
 * @author: xuboru on 2018/12/25
 * 226. 翻转二叉树
 * https://leetcode-cn.com/problems/invert-binary-tree/
 */
public class InvertTree
{
	public TreeNode invertTree(TreeNode root)
	{
		if (root == null)
			return null;
		TreeNode temp = invertTree(root.left);
		root.left = invertTree(root.right);
		root.right = temp;
		return root;
	}
}
