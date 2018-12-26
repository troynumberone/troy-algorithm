package com.troy.algorithm;

/**
 * @author: xuboru on 2018/12/26
 * 606. 根据二叉树创建字符串
 * https://leetcode-cn.com/problems/construct-string-from-binary-tree/
 */
public class Tree2str
{
	private StringBuilder result = new StringBuilder();

	public String tree2str(TreeNode t)
	{
		if (t == null)
			return result.toString();
		result.append(t.val);
		if (t.right != null)
		{
			result.append("(");
			tree2str(t.left);
			result.append(")");
			result.append("(");
			tree2str(t.right);
			result.append(")");
		}
		else if (t.left != null)
		{
			result.append("(");
			tree2str(t.left);
			result.append(")");
		}
		return result.toString();
	}
}
