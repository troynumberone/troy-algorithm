package com.troy.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author: xuboru on 2018/12/25
 * 590. N叉树的后序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 */
public class Postorder
{
	public List<Integer> postorder(Node root)
	{
		List<Integer> result = new ArrayList<>();
		if (root == null)
			return result;
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty())
		{
			Node current = stack.pop();
			if (current.children != null)
			{
				for (int i = 0; i < current.children.size(); i++)
				{
					stack.push(current.children.get(i));
				}
			}
			result.add(current.val);
		}
		List<Integer> resultR = new ArrayList<>();
		for (int i = result.size() - 1; i >= 0; i--)
		{
			resultR.add(result.get(i));
		}
		return resultR;
	}
}
