package com.study.wqz.leetcode.dynamic_programming;

/**
 * 对一个字符串进行三种操作，插入，删除，替换。现在给定两个字符串s1,s2.计算最少需要多少次操作。
 */
public class MinDistance {

    public static int getMinDistance(String s1,String s2){
        int m=s1.length(),n=s2.length();
        int[][] dp=new int[m+1][n+1];
        for (int i=1;i<=m;i++){
            dp[i][0]=i;
        }
        for(int j=1;j<=n;j++){
            dp[0][j]=j;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=getMin((dp[i-1][j])+1,dp[i][j-1]+1,dp[i-1][j-1]+1);
                }
            }
        }
        return dp[m][n];
    }

    private static int getMin(int a,int b,int c){
        return Math.min(a,Math.min(b,c));
    }

    public static void main(String[] args){
        System.out.println(getMinDistance("intention","execution"));
    }
}
