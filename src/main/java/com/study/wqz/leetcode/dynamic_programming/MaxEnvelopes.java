package com.study.wqz.leetcode.dynamic_programming;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author ：wuqizhen
 * @date ：Created in 2020/12/22 15:24
 * @description：嵌套信封（先按一定规则进行排序，再找最长递增子序列）
 * @modified By：
 * @version: $
 * @since ：
 */
public class MaxEnvelopes {
    public static int getMaxEnvelopes(int[][] envelops){
        int n=envelops.length;
        Arrays.sort(envelops, (ints, t1) -> ints[0]==t1[0]? t1[1]-ints[1]:ints[0]-t1[0]);
        int[] height=new int[n];
        for(int i=0;i<n;i++){
            height[i]=envelops[i][1];
        }
        return LengthOfLIS.getLengthOfLIS(height);
    }

    public static void main(String[] args){
        int number=getMaxEnvelopes(new int[][]{{1,8},{5,2},{6,7},{2,3},{5,4},{6,4}});
        System.out.println(number);
    }
}
