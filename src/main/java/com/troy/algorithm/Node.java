package com.troy.algorithm;

import java.util.List;

/**
 * @author: xuboru on 2018/12/25
 */
public class Node
{
	public int val;
	public List<Node> children;

	public Node()
	{
	}

	public Node(int _val, List<Node> _children)
	{
		val = _val;
		children = _children;
	}
}
