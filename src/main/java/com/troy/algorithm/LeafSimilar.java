package com.troy.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xuboru on 2018/12/25
 * 872. 叶子相似的树
 * https://leetcode-cn.com/problems/leaf-similar-trees/
 */
public class LeafSimilar
{
	public boolean leafSimilar(TreeNode root1, TreeNode root2)
	{
		List<Integer> l1 = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();
		dfs(root1, l1);
		dfs(root2, l2);
		if (l1.size() != l2.size())
			return false;
		for (int i = 0; i < l1.size(); i++)
		{
			if (l1.get(i) != l2.get(i))
				return false;
		}
		return true;

	}

	public void dfs(TreeNode root1, List<Integer> list)
	{
		if (root1 == null)
			return;
		if (root1.left == null && root1.right == null)
		{
			list.add(root1.val);
		}
		if (root1.left != null)
			dfs(root1.left, list);
		if (root1.right != null)
			dfs(root1.right, list);
	}
}
