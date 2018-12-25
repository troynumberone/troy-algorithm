package com.troy.algorithm;

import java.util.*;

/**
 * @author: xuboru on 2018/12/25
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 * 589. N叉树的前序遍历
 * 递归使用stack
 *
 */
public class Preorder
{
	private List<Integer> result = new ArrayList<>();

	public List<Integer> preorder(Node root)
	{
		Stack<Node> stack = new Stack<>();
		if (root == null)
			return result;
		stack.push(root);
		while (!stack.isEmpty())
		{
			Node current = stack.pop();
			result.add(current.val);
			if (current.children != null)
			{
				for (int i = current.children.size() - 1; i >= 0; i--)
				{
					stack.push(current.children.get(i));
				}
			}
		}
		return result;
	}
}
