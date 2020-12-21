package com.study.wqz.leetcode.normal.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：wuqizhen
 * @date ：Created in 2020/12/15 18:50
 * @description：给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * @modified By：
 * @version: $
 * @since ：
 */
public class LongestPalindrome {

    //中心扩散
    public static String getLongest(String s){
        int len=s.length();
        if(len<2){
            return s;
        }
        String longest="";
        for(int i=0;i<len-1;i++){
            String sub=findPalindrome(s,i,i);
            String sub2=findPalindrome(s,i,i+1);
            String longer="";
            if(sub.length()<sub2.length()){
                longer=sub2;
            }else{
                longer=sub;
            }
            if(longest.length()<longer.length()){
                longest=longer;
            }
        }
        return longest;
    }

    public static String findPalindrome(String s,int left,int right){
        int i=left;
        int j=right;
        while(i>=0&&j<s.length()) {
             if(s.charAt(i) == s.charAt(j)) {
                 i--;
                 j++;
            }else{
                 break;
             }
        }
        return s.substring(i+1,j);
    }

    //动态规划

    public static void main(String[] args){
        getLongest("bb");
    }
}
