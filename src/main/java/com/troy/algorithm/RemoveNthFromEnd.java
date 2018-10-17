package com.troy.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xuboru on 2018/10/16
 */
public class RemoveNthFromEnd
{
	public ListNode removeNthFromEnd(ListNode head, int n)
	{
		if (head == null)
			return null;
		List<ListNode> listNodeList = new ArrayList<>();
		ListNode now = head;
		while (now != null)
		{
			listNodeList.add(now);
			now = now.next;
		}

		int num = listNodeList.size();
		int index = num - n;
		if (index == 0)
		{
			head = head.next;
		}
		else if (index == num - 1)
		{
			listNodeList.get(index - 1).next = null;
		}
		else
		{
			listNodeList.get(index - 1).next = listNodeList.get(index).next;
		}
		return head;
	}
}
