package com.newStart;

import java.util.HashSet;
import java.util.Set;

//如果使用双指针来做的话
//对于abcdcd这种可能会忽略b开始的字符串
//而采用滑动窗口的话可以使得每种情况都考虑在内
public class Q3 {
    public static void main(String[] args) {
        Q3 test=new Q3();
        System.out.println(test.lengthOfLongestSubstring("abcabcbb"));
    }
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set=new HashSet<Character>();//记录字符的字典
        int result=0;
        int rk=-1;
        int n=s.length();
        for (int i = 0; i < n; i++) {//每一种开头
            if(i>0){
                set.remove(s.charAt(i-1));
            }
            while (rk+1<n&&!set.contains(s.charAt(rk+1))){//当前i开头所能滑到的最远距离
                rk++;
                set.add(s.charAt(rk));
            }
            result=Math.max(result,rk-i+1);
        }
        return result;
    }
}
