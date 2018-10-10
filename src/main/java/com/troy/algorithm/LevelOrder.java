package com.troy.algorithm;

import java.util.*;

/**
 * @author: xuboru on 2018/10/10
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

例如:
给定二叉树: [3,9,20,null,null,15,7],

3
/ \
9  20
/  \
15   7
返回其层次遍历结果：

[
[3],
[9,20],
[15,7]
]
 */
public class LevelOrder
{
	public List<List<Integer>> levelOrder(TreeNode root)
	{
		List<List<Integer>> list = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		if (root != null)
			queue.add(root);
		while (!queue.isEmpty())
		{
			Queue<TreeNode> nextQueue = new LinkedList<>();
			List<Integer> temp = new ArrayList<>();
			while (!queue.isEmpty())
			{
				TreeNode treeNode = queue.poll();
				temp.add(treeNode.val);
				if (treeNode.left != null)
				{
					nextQueue.add(treeNode.left);
				}
				if (treeNode.right != null)
				{
					nextQueue.add(treeNode.right);
				}
			}
			queue = nextQueue;
			list.add(temp);
		}
		return list;
	}
}
