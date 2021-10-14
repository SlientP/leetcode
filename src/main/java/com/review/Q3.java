package com.review;

import java.util.ArrayDeque;


// 3. Longest Substring Without Repeating Characters
// Given a string s, find the length of the longest substring without repeating characters.

//  

// Example 1:

// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.
// Example 2:

// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.
// Example 3:

// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
// Example 4:

// Input: s = ""
// Output: 0

public class Q3 {
    public static void main(String[] args) {
        Q3 test=new Q3();
        System.out.println(test.lengthOfLongestSubstring("abcabcbb"));
    }
    public int lengthOfLongestSubstring(String s) {
        int len=s.length();
        if(len==0) return 0;
        int result=0;
        ArrayDeque<Character> queue=new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            if(queue.isEmpty()||!queue.contains(s.charAt(i))){
                queue.add(s.charAt(i));
            }else{
                result=Math.max(result, queue.size());
                while(queue.peek()!=s.charAt(i)) queue.pop();
                queue.pop();
                queue.add(s.charAt(i));
            }
        }
        //missing cases 
        //s=" " 当s为无重复的字符串的时候就会出现没有任何冲突
        result=Math.max(result, queue.size());
        return result;
    }
}
