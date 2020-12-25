package com.study.wqz.leetcode.dynamic_programming;

/**
 * @author ：wuqizhen
 * @date ：Created in 2020/12/22 18:21
 * @description：最大子数组问题
 * @modified By：
 * @version: $
 * @since ：
 */
public class MaxSubArray {
    public static int getMaxSubArray(int[] nums){
        int n=nums.length;
        if(n==0)return 0;
        int[] dp=new int[n];
        dp[0]=nums[0];
        for(int i=1;i<n;i++){
            dp[i]=Math.max(nums[i],nums[i]+dp[i-1]);
        }
        int res=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            res=Math.max(res,dp[i]);
        }
        return res;
    }

    public static void main(String[] args){
        int max=getMaxSubArray(new int[]{-3,1,3,-1,2,-4,2});
        System.out.println(max);
    }
}
