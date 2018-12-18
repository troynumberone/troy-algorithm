package com.troy.algorithm;

/**
 * @author: xuboru on 2018/10/15
 */
public class IsPalindrome
{
	public boolean isPalindrome(int x)
	{
		if (x < 0)
			return false;
		if (x < 10)
			return true;
		String s = String.valueOf(x);
		for (int i = 0, j = s.length() - 1; i < j; i++, j--)
		{
			if (s.charAt(i) != s.charAt(j))
				return false;
		}
		return true;
	}

	/**
	 * 234. 回文链表
	 * https://leetcode-cn.com/problems/palindrome-linked-list/
	 * @param head
	 * @return
	 */
	public boolean isPalindrome(ListNode head)
	{
		if (head == null)
			return true;
		//使用快慢指针找到中间节点，反转后面的链表，然后双链表进行比较
		ListNode slow, fast, mid;
		for (slow = head, fast = head != null ? head.next : null;
			 fast != null; slow = slow.next, fast = fast.next.next)
		{
			if (fast.next == null)
			{
				break;
			}
		}
		mid = slow.next;
		slow.next = null;
		mid = reverseList(mid);
		for (; head != null && mid != null; head = head.next, mid = mid.next)
		{
			if (head.val != mid.val)
				return false;
		}
		return true;
	}

	private ListNode reverseList(ListNode head)
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

	public static void main(String[] args)
	{
		System.out.println(new IsPalindrome().isPalindrome(10));
	}
}
