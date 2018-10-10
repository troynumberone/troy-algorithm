package com.troy.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xuboru on 2018/10/10
 * 定一个二叉树，返回所有从根节点到叶子节点的路径。

说明: 叶子节点是指没有子节点的节点。

示例:

输入:

1
/   \
2     3
\
5

输出: ["1->2->5", "1->3"]

解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */
public class BinaryTreePaths
{
	public List<String> binaryTreePaths(TreeNode root)
	{
		List<String> list = new ArrayList<>();
		setPath(list, null, root);
		return list;
	}

	private void setPath(List<String> list, String pathPre, TreeNode node)
	{
		if (node != null)
		{
			String path;
			if (pathPre == null)
			{
				path = node.val + "";
			}
			else
			{
				path = pathPre + "->" + node.val;
			}
			if (node.left == null && node.right == null)
			{
				list.add(path);
			}
			else
			{
				setPath(list, path, node.left);
				setPath(list, path, node.right);
			}
		}
	}
}
