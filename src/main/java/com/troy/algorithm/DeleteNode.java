package com.troy.algorithm;

/**
 * @author: xuboru on 2018/12/18
 */
public class DeleteNode
{
	public void deleteNode(ListNode node)
	{
		ListNode next = node.next;
		node.val = next.val;
		node.next = next.next;
	}
}
