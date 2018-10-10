package com.troy.algorithm;

import java.util.Stack;

/**
 * @author: xuboru on 2018/10/10
 */
public class BSTIterator
{
	private Stack<TreeNode> stack = new Stack<>();

	public BSTIterator(TreeNode root)
	{
		init(root);
	}

	private void init(TreeNode node)
	{
		if (node != null)
		{
			stack.push(node);
			if (node.left != null)
			{
				init(node.left);
			}
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext()
	{
		return !stack.empty();
	}

	/** @return the next smallest number */
	public int next()
	{
		TreeNode node = stack.pop();
		if (node.right != null)
		{
			init(node.right);
		}
		return node.val;
	}
}


