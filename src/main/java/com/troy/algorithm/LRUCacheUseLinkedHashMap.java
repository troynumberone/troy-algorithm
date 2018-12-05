package com.troy.algorithm;

import java.util.LinkedHashMap;
/**
 * @author: xuboru on 2018/12/4
 */
public class LRUCacheUseLinkedHashMap extends LinkedHashMap
{
	protected int maxElements;
	public LRUCacheUseLinkedHashMap(int maxSize)
	{
		super(maxSize, 0.75F, true);
		maxElements = maxSize;
	}

	protected boolean removeEldestEntry(java.util.Map.Entry eldest)
	{
		return size() > maxElements;
	}
}
