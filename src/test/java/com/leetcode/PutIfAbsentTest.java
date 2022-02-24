package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: EnjoyCoding
 * @Date: 2020\8\8 0008 22:37
 * @Description:
 */
public class PutIfAbsentTest {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.putIfAbsent("test","val");
		System.out.println(map.get("test"));

		map.putIfAbsent("test","val2");
		System.out.println(map.get("test"));
	}
}
