package com.leetcode.backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: EnjoyCoding
 * @Date: 2020\7\21 0021 22:48
 * @Description:
 */
public class LeetCode47 {
	private List<List<Integer>> resultList=new LinkedList<>();
	private	List<Integer> indexList=new LinkedList<>();


	public List<List<Integer>> permuteUnique(int[] nums) {
		LinkedList<Integer> backTracklist=new LinkedList<>();
		backTrack(backTracklist,nums,indexList);
		System.out.println(resultList);
		return resultList;
	}

	public void backTrack(LinkedList<Integer> backTracklist,int[] nums,List<Integer> indexList){
		//终止条件
		if(backTracklist.size()==nums.length) {
			resultList.add(backTracklist);
			return;
		}

		for(int i=0;i<nums.length;i++) {
			//判断条件
			if(indexList.contains(i)){
				continue;
			}
			//做出选择
			backTracklist.add(nums[i]);
			indexList.add(i);

			backTrack(backTracklist,nums,indexList);
			//取消选择
			backTracklist.removeLast();
			indexList=new LinkedList<>();
		}
	}
}

