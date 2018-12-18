package com.troy.algorithm;

/**
 * 876. 链表的中间结点
 * @author: xuboru on 2018/12/18
 * 快慢指针
 */
public class MiddleNode
{
	public ListNode middleNode(ListNode head)
	{
		ListNode slow, fast;
		for (slow = head, fast = slow.next;
			 fast != null;
			 slow = slow.next, fast = fast.next.next)
		{
			if (fast.next == null)
				return slow.next;
		}
		return slow;
	}

}
