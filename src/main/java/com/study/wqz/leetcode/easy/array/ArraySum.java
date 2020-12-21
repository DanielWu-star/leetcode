package com.study.wqz.leetcode.easy.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：wuqizhen
 * @date ：Created in 2020/12/14 20:50
 * @description：给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * @modified By：
 * @version: $
 * @since ：
 */

public class ArraySum {

    public static int[] findTwoSumIndex(int[] nums,int target){
        int[] array=new int[2];
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashMap.containsKey(target - nums[i])) {
                array[0]=hashMap.get(target - nums[i]);
                array[1]=i;
            }
            hashMap.put(nums[i], i);
        }
        return array;
    }
}
