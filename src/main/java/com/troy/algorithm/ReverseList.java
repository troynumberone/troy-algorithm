package com.troy.algorithm;

import java.util.List;

/**
 * @author: xuboru on 2018/12/18
 * 206. 反转链表
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class ReverseList
{
	public ListNode reverseList(ListNode head)
	{
		ListNode pre, current;
		for (pre = null, current = head; current != null; )
		{
			ListNode next = current.next;
			current.next = pre;
			pre = current;
			current = next;
		}
		return pre;
	}
}
