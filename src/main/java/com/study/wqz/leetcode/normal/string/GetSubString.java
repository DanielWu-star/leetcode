package com.study.wqz.leetcode.normal.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ：wuqizhen
 * @date ：Created in 2020/12/15 10:46
 * @description：给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 * @modified By：
 * @version: $
 * @since ：
 */
public class GetSubString {
    //暴力法
    public static int getLongestSubStringLength(String s){
        String subString="";
        for(int i=0;i<s.length();i++) {
            String sub="";
            for (int x=i;x<s.length();x++) {
                String str = s.charAt(x) + "";
                if(!sub.contains(str)){
                    sub+=str;
                    if(subString.length()<sub.length()){
                        subString = sub;
                    }
                }else{
                    if(subString.length()<sub.length()) {
                        subString = sub;
                    }
                    break;
                }
            }
        }
        return subString.length();
    }

    public static int getLongestSubStringLengthSet(String s){
        int right=0;
        String subString="";
        HashSet<Character> set=new HashSet<>();
        for(int left=0;left<s.length();left++){
            String sub="";
            while(right<s.length()&&!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
                if(right>=s.length()){
                    break;
                }
            }
            set.remove(s.charAt(left));
            sub=s.substring(left,right);
            if(subString.length()<=sub.length()){
                subString=sub;
            }
        }
        return subString.length();
    }

    //hashMap优化

    public static int getLongestSubStringLengthMap(String s){
        int left=0,n=s.length(),res=0;
        Map<Character,Integer> map = new HashMap<>();
        for (int i=0;i<n;++i){
            char chr = s.charAt(i);
            if (map.containsKey(chr)){
                //更新左边界
                left = Math.max(left,map.get(s.charAt(i))+1);
            }
            map.put(chr,i);
            res = Math.max(res,i-left+1);
        }
        return res;
    }



    public static void main(String[] args){
        getLongestSubStringLengthMap("abcabcbb");
    }
}
