package com.troy.algorithm;

/**
 * @author: xuboru on 2018/10/15
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。

你可以假设除了数字 0 之外，这两个数字都不会以零开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
 */
public class AddTwoNumbers
{
	public ListNode addTwoNumbers(ListNode l1, ListNode l2)
	{
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		ListNode resultHead = null;
		ListNode resultNow = null;
		ListNode listNodel1now = l1;
		ListNode listNodel2now = l2;
		boolean needAdd = false;
		while (listNodel1now != null || listNodel2now != null || needAdd == true)
		{
			int l1v;
			if (listNodel1now == null)
			{
				l1v = 0;
			}
			else
			{
				l1v = listNodel1now.val;
				listNodel1now = listNodel1now.next;
			}
			int l2v;
			if (listNodel2now == null)
			{
				l2v = 0;
			}
			else
			{
				l2v = listNodel2now.val;
				listNodel2now = listNodel2now.next;
			}
			int v = l1v + l2v + (needAdd ? 1 : 0);
			if (v >= 10)
			{
				needAdd = true;
				v -= 10;
			}
			else
			{
				needAdd = false;
			}
			ListNode now = new ListNode(v);
			if (resultHead == null)
			{
				resultHead = now;
				resultNow = now;
			}
			else
			{
				resultNow.next = now;
				resultNow = now;
			}

		}
		return resultHead;
	}
}
