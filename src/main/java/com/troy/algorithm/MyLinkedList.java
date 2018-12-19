package com.troy.algorithm;

/**
 * @author: xuboru on 2018/12/18
 */
public class MyLinkedList
{

	class DoubleLinkedNode
	{
		int val;
		DoubleLinkedNode pre;
		DoubleLinkedNode next;

		private DoubleLinkedNode(int val)
		{
			this.val = val;
		}

		public String toString()
		{
			return val + "";
		}
	}

	private int size = 0;
	private DoubleLinkedNode head;
	private DoubleLinkedNode tail;

	/** Initialize your data structure here. */
	public MyLinkedList()
	{

	}

	/** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
	public int get(int index)
	{
		DoubleLinkedNode node = getNode(index);
		return node == null ? -1 : node.val;
	}

	public DoubleLinkedNode getNode(int index)
	{
		if (index < 0 || index >= size)
			return null;
		//可以进行简单的优化，index>=size/2从尾部开始查询
		if (index < size / 2)
		{
			int countHead = index + 1;
			DoubleLinkedNode c = head;
			for (int count = 1; count < countHead; c = c.next,count++);
			return c;
		}
		else
		{
			int countTail = size - index;
			System.out.println(countTail);
			DoubleLinkedNode c = tail;
			for (int count = 1; count < countTail; c = c.pre,count++);
			return c;
		}

	}

	/** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
	public void addAtHead(int val)
	{
		DoubleLinkedNode add = new DoubleLinkedNode(val);
		if (head == null)
		{
			head = add;
			tail = add;
		}
		else
		{
			add.next = head;
			head.pre = add;
			head = add;
		}
		size++;
	}

	/** Append a node of value val to the last element of the linked list. */
	public void addAtTail(int val)
	{
		DoubleLinkedNode add = new DoubleLinkedNode(val);
		if (tail == null)
		{
			head = add;
			tail = add;
		}
		else
		{
			tail.next = add;
			add.pre = tail;
			tail = add;
		}
		size++;

	}

	/** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
	public void addAtIndex(int index, int val)
	{
		if (index == 0)
			addAtHead(val);
		else if (index == size)
			addAtTail(val);
		else if (index > 0 && index < size)
		{
			DoubleLinkedNode add = new DoubleLinkedNode(val);
			DoubleLinkedNode node = getNode(index);
			DoubleLinkedNode pre = node.pre;
			pre.next = add;
			add.pre = pre;
			add.next = node;
			node.pre = add;
			size++;
		}
	}

	/** Delete the index-th node in the linked list, if the index is valid. */
	public void deleteAtIndex(int index)
	{
		if (index >= 0 && index < size)
		{
			if (size == 1)
			{
				head = null;
				tail = null;
			}
			else
			{
				DoubleLinkedNode deleteNode = getNode(index);
				DoubleLinkedNode pre = deleteNode.pre;
				DoubleLinkedNode next = deleteNode.next;
				if (pre == null)
				{
					head = next;
					next.pre = pre;
				}
				else if (next == null)
				{
					pre.next = next;
					tail = pre;
				}
				else
				{
					pre.next = next;
					next.pre = pre;
				}
				deleteNode.pre = null;
				deleteNode.next = null;
			}
			size--;
		}
	}

	public void print()
	{
		StringBuilder stringBuilder = new StringBuilder();

		for (DoubleLinkedNode c = head; c != null; c = c.next)
		{
			stringBuilder.append(c.val + "->");
		}
		System.out.println("head" + head + "tail" + tail + "list"+stringBuilder.toString());
	}

	public static void main(String[] args)
	{
		MyLinkedList myLinkedList=new MyLinkedList();
		myLinkedList.addAtHead(1);
		myLinkedList.print();
		myLinkedList.addAtTail(3);
		myLinkedList.print();
		myLinkedList.addAtIndex(1,2);
		myLinkedList.print();
		System.out.println(myLinkedList.get(1));
		myLinkedList.deleteAtIndex(1);
		myLinkedList.print();
		System.out.println(myLinkedList.get(1));
	}
}