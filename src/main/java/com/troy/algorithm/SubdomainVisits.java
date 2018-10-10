package com.troy.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: xuboru on 2018/10/10
 */
public class SubdomainVisits
{
	public List<String> subdomainVisits(String[] cpdomains)
	{
		List<String> result = new ArrayList<>();
		Map<String, Integer> countMap = new HashMap<>();
		if (cpdomains != null)
		{
			for (String item : cpdomains)
			{
				String[] countAndDomain = item.split(" ");
				String[] domainSplit = countAndDomain[1].split("\\.");
				int rootIndex = domainSplit.length - 1;
				int count = Integer.valueOf(countAndDomain[0]);
				String key = null;
				for (int i = rootIndex; i >= 0; i--)
				{
					if (key == null)
					{
						key = domainSplit[i];
					}
					else
					{
						key = domainSplit[i] + "." + key;
					}
					countMap.merge(key, count, (x, y) -> x + y);
				}
			}
			countMap.forEach((x, y) -> result.add(y.toString() + " " + x));
		}
		return result;
	}
}
