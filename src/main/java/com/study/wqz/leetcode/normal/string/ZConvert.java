package com.study.wqz.leetcode.normal.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：wuqizhen
 * @date ：Created in 2020/12/15 20:57
 * @description：将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * @modified By：
 * @version: $
 * @since ：
 */
public class ZConvert {
    public static String convert(String s,int numRows){
        int len=s.length();
        Map<Integer,String> maps=new HashMap<>();
        int middle=0;
        for(int i=0;i<len;i++){
            int list=(i-middle)/numRows;
            int mediaNumber=2*(numRows-1);
            int top=0;
            int bottom=numRows-1;
            int location=0;
            if(list>0){
                top+=(mediaNumber)*list;
                bottom+=(mediaNumber)*list;
            }
            if(i>=top&&i<=bottom){
                location=i-(mediaNumber)*list;
            }else{
                location=(numRows-1)-(i-bottom+(mediaNumber));
                middle++;
            }
            if(maps.containsKey(location)) {
                String next=maps.get(location)+s.charAt(i)+"";
                maps.put(location, next);
            }else{
                maps.put(location, s.charAt(i) + "");
            }

        }
        StringBuilder resultString=new StringBuilder();
        for(Map.Entry<Integer,String> entry:maps.entrySet()){
            resultString.append(entry.getValue());
        }
        return resultString.toString();
    }

    public static String convertDirection(String s,int numRows){
        if (numRows == 1) return s;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());
        int curRow = 0;
        boolean goingDown = false;
        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }
        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }

    public static void main(String[] args){
        System.out.println(convert("LEETCODEISHIRING",4));
    }
}
