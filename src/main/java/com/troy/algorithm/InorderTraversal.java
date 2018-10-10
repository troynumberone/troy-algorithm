package com.troy.algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author: xuboru on 2018/10/10
 * 给定一个二叉树，返回它的中序 遍历。
 * 示例:

输入: [1,null,2,3]
1
\
2
/
3

输出: [1,3,2]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class InorderTraversal
{
	Stack<TreeNode> stack = new Stack<>();

	public List<Integer> inorderTraversal(TreeNode root)
	{
		List<Integer> result = new LinkedList<>();
		init(root);
		while (!stack.empty())
		{
			TreeNode treeNode = stack.pop();
			result.add(treeNode.val);
			init(treeNode.right);
		}
		return result;
	}

	private void init(TreeNode node)
	{
		TreeNode cu = node;
		while (cu != null)
		{
			stack.push(cu);
			cu = cu.left;
		}
	}
}
