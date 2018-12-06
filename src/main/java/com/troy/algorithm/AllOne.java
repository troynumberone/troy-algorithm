package com.troy.algorithm;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author: xuboru on 2018/12/5
 * https://leetcode-cn.com/explore/interview/card/bytedance/245/data-structure/1033/
 */
public class AllOne
{

	private HashMap<String, Integer> map;
	private HashMap<Integer, AllOneNode> countMap;
	private AllOneNode head;
	private AllOneNode tail;

	public AllOne()
	{
		map = new HashMap<>();
		countMap = new HashMap<>();
	}

	public class AllOneNode
	{
		private int count;
		private HashSet<String> set;
		private AllOneNode pre;
		private AllOneNode next;

		public AllOneNode(int count)
		{
			this.count = count;
			set = new HashSet<>();
		}
	}

	/** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
	public void inc(String key)
	{
		Integer v = map.get(key);
		int incV;
		if (v == null)//如果不存在
		{
			incV = 1;
			map.put(key, incV);
			AllOneNode allOneNode = countMap.get(incV);
			if (allOneNode == null)
			{
				allOneNode = new AllOneNode(incV);
				countMap.put(incV, allOneNode);
				if (head == null)
				{
					head = allOneNode;
					tail = allOneNode;
				}
				else
				{
					allOneNode.next = head;
					head.pre = allOneNode;
					head = allOneNode;
				}
			}
			allOneNode.set.add(key);
		}
		else
		{
			incV = v + 1;
			map.put(key, incV);
			AllOneNode allOneNode = countMap.get(incV);
			AllOneNode allOneNodeOld = countMap.get(v);
			if (allOneNode == null)
			{
				allOneNode = new AllOneNode(incV);
				countMap.put(incV, allOneNode);
				AllOneNode next = allOneNodeOld.next;
				allOneNodeOld.next = allOneNode;
				allOneNode.pre = allOneNodeOld;
				allOneNode.next = next;
				if (next == null)
				{
					tail = allOneNode;
				}
				else
				{
					next.pre = allOneNode;
				}
			}
			allOneNode.set.add(key);
			allOneNodeOld.set.remove(key);
			if (allOneNodeOld.set.isEmpty())
			{
				countMap.remove(v);
				AllOneNode pre = allOneNodeOld.pre;
				allOneNodeOld.pre = null;
				allOneNodeOld.next = null;
				if (pre == null)
				{
					head = allOneNode;
				}
				else
				{
					pre.next = allOneNode;
				}
				allOneNode.pre = pre;
			}
		}
	}

	/** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
	public void dec(String key)
	{
		Integer v = map.get(key);
		if (v == null)
			return;
		int decV = v - 1;
		AllOneNode allOneNodeOld = countMap.get(v);
		if (decV == 0)
		{
			map.remove(key);
			allOneNodeOld.set.remove(key);
			if (allOneNodeOld.set.isEmpty())
			{
				countMap.remove(v);
				AllOneNode pre = allOneNodeOld.pre;
				AllOneNode next = allOneNodeOld.next;
				allOneNodeOld.pre = null;
				allOneNodeOld.next = null;
				if (pre == null)
				{
					head = next;
				}
				else
				{
					pre.next = next;
				}
				if (next == null)
				{
					tail = null;
				}
				else
				{
					next.pre = pre;
				}
			}
		}
		else
		{
			map.put(key, decV);
			AllOneNode allOneNode = countMap.get(decV);
			if (allOneNode == null)
			{
				allOneNode = new AllOneNode(decV);
				countMap.put(decV, allOneNode);
				AllOneNode pre = allOneNodeOld.pre;
				allOneNodeOld.pre = allOneNode;
				allOneNode.next = allOneNodeOld;
				allOneNode.pre = pre;
				if (pre == null)
				{
					head = allOneNode;
				}
				else
				{
					pre.next = allOneNode;
				}
			}
			allOneNode.set.add(key);
			allOneNodeOld.set.remove(key);
			if (allOneNodeOld.set.isEmpty())
			{
				countMap.remove(v);
				AllOneNode next = allOneNodeOld.next;
				allOneNodeOld.pre = null;
				allOneNodeOld.next = null;
				if (next == null)
				{
					tail = allOneNode;
				}
				else
				{
					next.pre = allOneNode;
				}
				allOneNode.next = next;
			}

		}

	}

	/** Returns one of the keys with maximal value. */
	public String getMaxKey()
	{
		return tail == null ? "" : tail.set.iterator().next();

	}

	/** Returns one of the keys with Minimal value. */
	public String getMinKey()
	{
		return head == null ? "" : head.set.iterator().next();
	}
}
