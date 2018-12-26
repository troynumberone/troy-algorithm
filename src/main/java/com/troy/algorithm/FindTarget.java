package com.troy.algorithm;

import java.util.*;

/**
 * @author: xuboru on 2018/12/26
 * 653. 两数之和 IV - 输入 BST
 * https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/
 */
public class FindTarget
{
	Set<Integer> set = new HashSet<>();
	public boolean findTarget(TreeNode root, int k)
	{
		if (root == null)
			return false;
		if (findTarget(root.left, k)){
			return true;
		}
		if (set.contains(k - root.val))
		{
			return true;
		}
		else
		{
			set.add(root.val);
		}
		set.add(root.val);
		return findTarget(root.right, k);
	}


}
