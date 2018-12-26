package com.troy.algorithm;

/**
 * @author: xuboru on 2018/12/25
 * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 * 538. 把二叉搜索树转换为累加树
 *
 */
public class ConvertBST
{
	private int sum=0;
	public TreeNode convertBST(TreeNode root)
	{
		if (root==null)
			return null;
		convertBST(root.right);
		root.val+=sum;
		sum=root.val;
		convertBST(root.left);
		return root;
	}


}
