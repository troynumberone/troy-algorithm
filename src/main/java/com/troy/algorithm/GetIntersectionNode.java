package com.troy.algorithm;

/**
 * @author: xuboru on 2018/12/18
 * 160. 相交链表
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 */
public class GetIntersectionNode
{
	public ListNode getIntersectionNode(ListNode headA, ListNode headB)
	{
		int alength = 0;
		int blength = 0;
		for (ListNode a = headA; a != null; alength++, a = a.next)
			;
		if (alength == 0)
			return null;
		for (ListNode a = headB; a != null; blength++, a = a.next)
			;
		if (blength == 0)
			return null;
		int m = alength > blength ? alength - blength : blength - alength;
		ListNode a = headA, b = headB;
		if (alength > blength)
		{
			for (int i = 1; i <= m; i++, a = a.next)
				;
		}
		else
		{
			for (int i = 1; i <= m; i++, b = b.next)
				;
		}
		for (; a != null && b != null; a = a.next, b = b.next)
		{
			if (a==b)
				return a;
		}
		return null;
	}
}
