package com.troy.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: xuboru on 2018/12/25
 * 637. 二叉树的层平均值
 * https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/
 *
 */
public class AverageOfLevels
{
	public List<Double> averageOfLevels(TreeNode root)
	{
		List<Double> result = new ArrayList<>();
		if (root == null)
			return result;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int size = 1;
		int count = 0;
		int nextSize=0;
		long sum = 0;
		while (!queue.isEmpty())
		{
			count++;
			TreeNode node = queue.poll();
			if (node.left != null)
			{
				queue.add(node.left);
				nextSize++;
			}
			if (node.right != null)
			{
				queue.add(node.right);
				nextSize++;
			}
			sum += node.val;
			if (count == size)
			{
				result.add(sum * 1.0 / size);
				size = nextSize;
				nextSize = 0;
				sum = 0;
				count = 0;
			}
		}
		return result;
	}
}
