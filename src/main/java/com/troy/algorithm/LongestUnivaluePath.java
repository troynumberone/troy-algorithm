package com.troy.algorithm;

/**
 * @author: xuboru on 2018/12/20
 * 687. 最长同值路径
 * https://leetcode-cn.com/problems/longest-univalue-path/
 */
public class LongestUnivaluePath
{
	int max = 0;
	public int dfs(TreeNode root){
		if(root == null)
			return 0;
		int left = dfs(root.left);
		int right = dfs(root.right);

		if(root.left != null && root.left.val == root.val)
			left++;
		else
			left = 0;
		if(root.right != null && root.right.val == root.val)
			right++;
		else
			right = 0;
		max = Math.max(max,left + right);
		return Math.max(left,right);
	}
	public int longestUnivaluePath(TreeNode root) {
		dfs(root);
		return max;
	}
}
