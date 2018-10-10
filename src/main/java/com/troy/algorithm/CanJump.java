package com.troy.algorithm;

import java.util.Arrays;

/**
 * @author: xuboru on 2018/5/11
 */
public class CanJump
{
	public boolean canJump(int[] nums) {
		if (nums==null){
			return false;
		}
		if (nums.length==1){
			return true;
		}
		int[] re=new int[nums.length];
		re[0]=1;
		for (int i=1;i<nums.length;i++){
			for (int j=0;j<i;j++){
				if (re[j]==1 && j+nums[j]>=i){
					re[i]=1;
					break;
				}
			}
		}
		return re[nums.length-1]==1;
	}

	public static void main(String[] args){
		CanJump canJump=new CanJump();
		System.out.println(canJump.canJump(new int[]{3,2,1,0,4}));
	}
}
