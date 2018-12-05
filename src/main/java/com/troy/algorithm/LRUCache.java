package com.troy.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: xuboru on 2018/12/4
 */
public class LRUCache
{
	private int capacity;
	private CacheListNode head;//头结点为最近最少使用
	private CacheListNode tail;//尾节点为最近使用的
	private Map<Integer, CacheListNode> map;

	/**
	 * 双指针用于在变换节点位置的时候进行O(1)的操作
	 */
	public class CacheListNode
	{
		private int key;
		private int value;
		private CacheListNode next;
		private CacheListNode pre;

		public CacheListNode(int key, int value)
		{
			this.key = key;
			this.value = value;
		}

	}

	public LRUCache(int capacity)
	{
		this.capacity = capacity;
		map = new HashMap<>();
	}

	public int get(int key)
	{
		CacheListNode re = map.get(key);
		if (re == null)
		{
			return -1;
		}
		else
		{
			//最近访问的移动到节点末尾
			moveToTail(re);
			//print(head);
			return re.value;
		}
	}

	/**
	 * 最近访问的移动到节点末尾
	 * @param node 需要移动的节点
	 */
	private void moveToTail(CacheListNode node)
	{
		CacheListNode pre = node.pre;
		CacheListNode next = node.next;
		//节点本来在末尾的时候，其next节点为null
		if (next == null)
		{
			return;
		}
		else
		{
			//是头节点但不是尾节点的时候
			if (pre == null)
			{
				head = next;
				head.pre = null;
			}
			else
			{//中间节点
				System.out.println("pre" + pre.key + "next" + next.key);
				pre.next = next;
				next.pre = pre;
			}
			tail.next = node;
			node.pre = tail;
			tail = node;
			node.next = null;
		}
	}

	public void put(int key, int value)
	{
		CacheListNode node = map.get(key);
		if (node == null)
		{
			node = new CacheListNode(key, value);
			map.put(key, node);
			if (head == null)
			{
				head = node;
				tail = node;
			}
			else
			{
				node.pre = tail;
				tail.next = node;
				tail = node;
			}
		}
		else
		{
			node.value = value;
			moveToTail(node);
		}
		if (map.size() > capacity)
		{
			map.remove(head.key);
			CacheListNode next = head.next;
			if (next == null)
			{
				head = null;
				tail = null;
			}
			else
			{
				head.next = null;
				next.pre = null;
				head = next;
			}
		}
		//print(head);
	}

	private void print(CacheListNode node)
	{
		StringBuilder stringBuilder = new StringBuilder("");
		while (node != null)
		{
			stringBuilder.append(node.key + "->");
			node = node.next;
		}
		System.out.println(stringBuilder.toString());
	}

	public static void main(String[] arg)
	{

		int[][] mm = new int[][] { { 10, 13 }, { 3, 17 }, { 6, 11 }, { 10, 5 }, { 9, 10 }, { 13 }, { 2, 19 }, { 2 },
				{ 3 }, { 5, 25 }, { 8 }, { 9, 22 }, { 5, 5 }, { 1, 30 }, { 11 }, { 9, 12 }, { 7 }, { 5 }, { 8 }, { 9 },
				{ 4, 30 }, { 9, 3 }, { 9 }, { 10 }, { 10 }, { 6, 14 }, { 3, 1 }, { 3 }, { 10, 11 }, { 8 }, { 2, 14 },
				{ 1 }, { 5 }, { 4 }, { 11, 4 }, { 12, 24 }, { 5, 18 }, { 13 }, { 7, 23 }, { 8 }, { 12 }, { 3, 27 },
				{ 2, 12 }, { 5 }, { 2, 9 }, { 13, 4 }, { 8, 18 }, { 1, 7 }, { 6 }, { 9, 29 }, { 8, 21 }, { 5 },
				{ 6, 30 }, { 1, 12 }, { 10 }, { 4, 15 }, { 7, 22 }, { 11, 26 }, { 8, 17 }, { 9, 29 }, { 5 }, { 3, 4 },
				{ 11, 30 }, { 12 }, { 4, 29 }, { 3 }, { 9 }, { 6 }, { 3, 4 }, { 1 }, { 10 }, { 3, 29 }, { 10, 28 },
				{ 1, 20 }, { 11, 13 }, { 3 }, { 3, 12 }, { 3, 8 }, { 10, 9 }, { 3, 26 }, { 8 }, { 7 }, { 5 },
				{ 13, 17 }, { 2, 27 }, { 11, 15 }, { 12 }, { 9, 19 }, { 2, 15 }, { 3, 16 }, { 1 }, { 12, 17 }, { 9, 1 },
				{ 6, 19 }, { 4 }, { 5 }, { 5 }, { 8, 1 }, { 11, 7 }, { 5, 2 }, { 9, 28 }, { 1 }, { 2, 2 }, { 7, 4 },
				{ 4, 22 }, { 7, 24 }, { 9, 26 }, { 13, 28 }, { 11, 26 } };
		LRUCache lruCache = new LRUCache(10);
		for (int i = 0; i < mm.length; i++)
		{
			if (mm[i].length == 2)
			{
				System.out.println("put" + mm[i][0] + "-" + mm[i][1]);
				lruCache.put(mm[i][0], mm[i][1]);
			}
			else
			{
				System.out.println("get" + mm[i][0]);
				System.out.println("value" + lruCache.get(mm[i][0]));
			}
		}
	}
}
