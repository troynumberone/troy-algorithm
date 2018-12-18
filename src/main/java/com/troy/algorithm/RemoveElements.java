package com.troy.algorithm;

/**
 * @author: xuboru on 2018/12/18
 * 203. 移除链表元素
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
public class RemoveElements
{
	public ListNode removeElements(ListNode head, int val)
	{
		ListNode current = head;
		ListNode fakerHead = new ListNode(0);
		ListNode pre = fakerHead;
		fakerHead.next = head;
		while (current != null)
		{
			if (current.val == val)
			{
				pre.next = current.next;
				current.next = null;
				current = pre.next;
			}
			else
			{
				pre = current;
				current = current.next;
			}
		}
		head = fakerHead.next;
		fakerHead.next = null;
		return head;
	}
}
