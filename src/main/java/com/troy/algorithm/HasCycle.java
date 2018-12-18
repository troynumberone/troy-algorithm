package com.troy.algorithm;

/**
 * @author: xuboru on 2018/12/18
 * 141. 环形链表
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * https://www.cnblogs.com/songdechiu/p/6686520.html
 */
public class HasCycle
{
	public boolean hasCycle(ListNode head)
	{
		ListNode slow, fast;
		for (slow = head, fast = head != null ? head.next : null;
			 fast != null; slow = slow.next, fast = fast.next.next)
		{
			if (fast.next == null)
				return false;
			if (slow.val == fast.val)
				return true;
		}
		return false;
	}
}
