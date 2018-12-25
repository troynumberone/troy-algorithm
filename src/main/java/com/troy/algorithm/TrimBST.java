package com.troy.algorithm;

/**
 * @author: xuboru on 2018/12/25
 * 669. 修剪二叉搜索树
 * https://leetcode-cn.com/problems/trim-a-binary-search-tree/
 */
public class TrimBST
{
	public TreeNode trimBST(TreeNode root, int L, int R)
	{
		if (root == null)
			return null;
		if (root.val >= L && root.val <= R)
		{
			root.left = trimBST(root.left, L, R);
			root.right = trimBST(root.right, L, R);
			return root;
		}
		else if (root.val < L)
			return trimBST(root.right, L, R);
		else
			return trimBST(root.left, L, R);
	}
}
