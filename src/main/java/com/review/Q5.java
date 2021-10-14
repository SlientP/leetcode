package com.review;

// 5. Longest Palindromic Substring
// Example 1:

// Input: s = "babad"
// Output: "bab"
// Note: "aba" is also a valid answer.
// Example 2:

// Input: s = "cbbd"
// Output: "bb"
// Example 3:

// Input: s = "a"
// Output: "a"
// Example 4:

// Input: s = "ac"
// Output: "a"
public class Q5 {
    public static void main(String[] args) {
        Q5 test=new Q5();
        System.out.println(test.longestPalindrome("aaaaa"));
    }
    public String longestPalindrome(String s) {
        int len=s.length();
        boolean[][] dp=new boolean[len][len];
        //初始化为第一个字符
        String result=s.substring(0,1);
        for (int i = 0; i < len; i++) {
            dp[i][i]=true;
            if(i+1<len&&s.charAt(i)==s.charAt(i+1)) {
                dp[i][i+1]=true;
                result=s.substring(i,i+2);
            }
        }
        //这是遍历循环的关键
        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j-2; i++) {
                if(s.charAt(i)==s.charAt(j)&&dp[i+1][j-1]) dp[i][j]=true;
                if(result.length()<j-i+1&&dp[i][j]) {
                    result=s.substring(i,j+1);
                }
            }
        }
        return result;
    }
}
