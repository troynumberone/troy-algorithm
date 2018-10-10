package com.troy.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: xuboru on 2018/10/10
 */
public class LevelOrderBottom
{
	public List<List<Integer>> levelOrderBottom(TreeNode root)
	{
		List<List<Integer>> list = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		if (root != null)
		{
			queue.add(root);
			generate(list, queue);
		}
		return list;
	}

	private void generate(List<List<Integer>> list, Queue<TreeNode> queue)
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
		if (!nextQueue.isEmpty())
			generate(list, nextQueue);
		list.add(temp);
	}
}
