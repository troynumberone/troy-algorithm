package com.troy.algorithm;

/**
 * @author: xuboru on 2018/12/25
 * 235. 二叉搜索树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class LowestCommonAncestor
{
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode max,min;
		if (p.val>q.val){
			max=p;
			min=q;
		}else {
			max=q;
			min=p;
		}
		if (min.val>root.val)
			return lowestCommonAncestor(root.right,min,max);
		else if (max.val<root.val)
			return lowestCommonAncestor(root.left,min,max);
		else
			return root;
	}
}
