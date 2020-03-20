package com.sesshou.leetcode;

import java.util.HashSet;

/**
 * @author wp41128
 * @date 2020/2/28 11:43
 * @description：
 */
public class Longest_Palindromic_Substring {
    public static void main(String[] args) {
        Longest_Palindromic_Substring test=new Longest_Palindromic_Substring();
        test.longestPalindrome("abbac");
    }
    public String longestPalindrome(String s) {
        int n=s.length();
        boolean[][] p=new boolean[n][n];
        String result="";
        for (int j = 0; j < n ; j++) {
            for (int i = j; i >= 0; i--) {
                if(i==j) p[i][j]=true;
                else if(s.charAt(i)==s.charAt(j))
                System.out.println("i:"+i+",j:"+j);
            }
        }
//        for (int i = 0; i <n+1 ; i++) {
//            for (int j = i; j>=0; j--) {
//                if(i==j) p[i][j]=true;
//                else if(s.charAt(i)==s.charAt(j)&&p[i+1][j-1]){
//
//                }
//            }
//        }
        return "";
    }
    public boolean isPalindrome(String s){
        if(s.length()==1) return true;
        else if(s.length()==2) return s.charAt(0)==s.charAt(1);
        return s.charAt(0)==s.charAt(s.length()-1)&&isPalindrome(s.substring(1,s.length()-2));
    }
}
