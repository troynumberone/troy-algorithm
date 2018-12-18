package com.troy.algorithm;

/**
 * @author: xuboru on 2018/12/18
 * 21. 合并两个有序链表
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoLists
{
	public ListNode mergeTwoLists(ListNode l1, ListNode l2)
	{
		ListNode head = new ListNode(0), current = head;
		while (l1 != null && l2 != null)
		{
			if (l1.val <= l2.val)
			{
				current.next = l1;
				current = l1;
				l1 = l1.next;
			}
			else
			{
				current.next = l2;
				current = l2;
				l2 = l2.next;
			}
		}

		if (l1 != null)
		{
			current.next = l1;
		}

		if (l2 != null)
		{
			current.next = l2;
		}
		ListNode fakerhead = head;
		head = head.next;
		fakerhead.next = null;
		return head;
	}
}
