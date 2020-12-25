package com.study.wqz.leetcode.dynamic_programming;

/**
 * @author ：wuqizhen
 * @date ：Created in 2020/12/23 10:32
 * @description：最长公共子序列
 * @modified By：
 * @version: $
 * @since ：
 */
public class LCS {
    public static int longestCommonSubsequence(String str1,String str2){
        int m=str1.length(),n=str2.length();
        int[][] dp=new int[m+1][n+1];
        dp[0][n]=0;
        dp[m][0]=0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args){
        System.out.println(longestCommonSubsequence("ace","babcde"));
    }
}
