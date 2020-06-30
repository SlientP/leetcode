package com.sesshou.leetcode.Microsoft;

import java.util.Arrays;

/**
 * @author wp41128
 * @date 2020/6/29 9:54
 * @description：翻转字符串里的单词 II
 */
public class Reverse_Words_in_a_String_II {
    public static void main(String[] args) {
        Reverse_Words_in_a_String_II test=new Reverse_Words_in_a_String_II();
        char[] s=new char[]{'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
        test.reverseWordsV2(s);
        System.out.println(s);
    }
    //use extra space
    public void reverseWords(char[] s) {
        String source=new String(s);
        String[] sources=source.split(" ");
        StringBuilder result=new StringBuilder();
        for (int i = sources.length-1; i >=0 ; i--) {
            result.append(sources[i]);
            result.append(" ");
        }
        char[] results=result.substring(0,result.length()).toCharArray();
        for (int i = 0; i < result.length()-1 ; i++) {
            s[i]=results[i];
        }
    }
    //not use extra space
    public void reverseWordsV2(char[] s) {
        if(s.length<=1) return;
        reverse(s,0,s.length-1);
        System.out.println(s);
        int left=0;
        int right=0;
        while (right<s.length-1){
            while(right<s.length-1 && s[right]!=' ') right++;
            if(right==s.length-1){
                reverse(s, left, right);
            }else {
                reverse(s, left, right - 1);
            }
            right++;
            left=right;
        }
    }

    private void reverse(char[] s,int left,int right){
        while (left<right){
            char temp=s[left];
            s[left]=s[right];
            s[right]=temp;
            left++;
            right--;
        }
    }
}
