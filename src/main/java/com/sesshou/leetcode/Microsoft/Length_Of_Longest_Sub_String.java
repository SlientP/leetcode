package com.sesshou.leetcode.Microsoft;

/**
 * @author wp41128
 * @date 2020/7/6 14:38
 * @description：最长字串
 */
public class Length_Of_Longest_Sub_String {
    public static void main(String[] args) {
        Length_Of_Longest_Sub_String test=new Length_Of_Longest_Sub_String();
        System.out.println(test.lengthOfLongestSubstring("bbbbb"));
    }
    public int lengthOfLongestSubstring(String s) {
        int len=s.length();
        if(len<=1) return len;
        int i=0;
        int j=1;
        int maxSize=1;
        String maxString=s.substring(i,j);
        while (i<=j&&j<len){
            if(maxString.contains(String.valueOf(s.charAt(j)))){
                i+=maxString.indexOf(s.charAt(j))+1;
            }
            j++;
            maxString=s.substring(i,j);
            maxSize=Math.max(maxSize,maxString.length());

        }
        System.out.println("i:"+i+";j:"+j);
        return maxSize;
    }
}
