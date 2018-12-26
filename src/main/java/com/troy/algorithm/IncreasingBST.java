package com.troy.algorithm;

/**
 * @author: xuboru on 2018/12/26
 * 897. 递增顺序查找树
 * https://leetcode-cn.com/problems/increasing-order-search-tree/
 */
public class IncreasingBST
{
	public TreeNode increasingBST(TreeNode root)
	{
		if (root == null)
			return root;
		TreeNode newRoot;

		if (root.left==null && root.right==null){
			newRoot=root;
		}else if (root.left!=null && root.right==null){
			TreeNode left=increasingBST(root.left);
			newRoot=left;
			TreeNode current=left;
			for (; current.right!=null ; current=current.right);
			current.right=root;
			root.left=null;
		}else if (root.left==null && root.right!=null){
			TreeNode right=increasingBST(root.right);
			newRoot=root;
			root.right=right;
		}else {
			TreeNode left=increasingBST(root.left);
			newRoot=left;
			TreeNode current=left;
			for (; current.right!=null ; current=current.right);
			current.right=root;
			TreeNode right=increasingBST(root.right);
			root.right=right;
			root.left=null;
		}
		return newRoot;
	}
}
