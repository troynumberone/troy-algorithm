package com.troy.algorithm;

/**
 * @author: xuboru on 2019/1/3
 * 验证二叉搜索树
 *
 * 也可以中序遍历
 */
public class IsValidBST
{
	public boolean isValidBST(TreeNode root)
	{
		if (root == null)
			return true;
		if (root.right != null && root.right.val <= root.val)
			return false;
		if (root.left != null && root.left.val >= root.val)
			return false;
		return isValidBST(root.left, Long.MIN_VALUE, root.val) && isValidBST(root.right, root.val,
				Long.MAX_VALUE);
	}

	private boolean isValidBST(TreeNode root, long min, long max)
	{
		if (root == null)
			return true;
		if (root.left!=null&& !(root.left.val>min && root.left.val<root.val))
			return false;
		if (root.right!=null&& !(root.right.val>root.val && root.right.val<max))
			return false;
		return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val,
				max);
	}
}
