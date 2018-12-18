package com.troy.algorithm;

/**
 * @author: xuboru on 2018/12/18
 * 83. 删除排序链表中的重复元素
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 */
public class DeleteDuplicates
{
	public ListNode deleteDuplicates(ListNode head)
	{
		ListNode current = head;
		while (current != null)
		{
			ListNode next = current.next;
			if (next == null)
			{
				break;
			}
			else
			{
				if (next.val == current.val)
				{
					current.next=next.next;
					next.next = null;
				}else {
					current = next;
				}
			}
		}
		return head;
	}
}
