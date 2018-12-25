package com.troy.algorithm;

/**
 * @author: xuboru on 2018/12/25
 * 700. 二叉搜索树中的搜索
 * https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 */
public class SearchBST
{
	public TreeNode searchBST(TreeNode root, int val)
	{
		if (root == null)
			return null;
		if (root.val == val)
			return root;
		else if (val < root.val)
			return searchBST(root.left, val);
		else
			return searchBST(root.right, val);
	}
}
