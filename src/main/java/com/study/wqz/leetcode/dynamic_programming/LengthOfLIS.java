package com.study.wqz.leetcode.dynamic_programming;

import java.util.Arrays;

/**
 * @author ：wuqizhen
 * @date ：Created in 2020/12/22 14:14
 * @description：寻找最长递增子序列
 * @modified By：
 * @version: $
 * @since ：
 */
public class LengthOfLIS {
    public static int getLengthOfLIS(int[] nums){
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1);
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int res=0;
        for (int i=0;i<dp.length;i++){
            res=Math.max(res,dp[i]);
        }
        return res;
    }

    public static int getLengthOfLISPoker(int[] nums){
        int[] top=new int[nums.length];
        int piles=0;
        for (int poker : nums) {
            //左侧边界二分搜索
            int left = 0;
            int right = piles;
            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] > poker) {
                    right = mid;
                } else if (top[mid] < poker) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            //没有则新建piles;
            if (left == piles) {
                piles++;
            }
            top[left] = poker;
        }
        return piles;
    }

    public static void main(String[] args){
        int length=getLengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
        int lengthPoker=getLengthOfLISPoker(new int[]{10,9,2,5,3,7,101,18});
    }
}
