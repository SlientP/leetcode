package com.review;

//8. String to Integer (atoi)
// Example 1:
// Input: s = "42"
// Output: 42

// Example 2:
// Input: s = "   -42"
// Output: -42

// Example 3:
// Input: s = "4193 with words"
// Output: 4193

// Example 4:
// Input: s = "words and 987"
// Output: 0

// Example 5:
// Input: s = "-91283472332"
// Output: -2147483648
public class Q8 {
    class Solution {
        public int myAtoi(String str) {
            if(str == null) return 0;
            String str1 = str.trim();
            if(str1.length() == 0) return 0;//去掉字符串中开始和结尾的空格
            int flag = 1;//默认正数计算
            int i = 0;//默认无符号从0开始
            if(str1.charAt(0) == '-'){
                flag = -1;
                i = 1;
            }else if(str1.charAt(0) == '+'){
                i = 1;
            }
            int ans = 0;
            while( i < str1.length() && str1.charAt(i) >= '0' && str1.charAt(i) <= '9'){
                int n = (str1.charAt(i) - '0') * flag;//转化为数字 包括符号
                if(ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && n > 7)){
                    return Integer.MAX_VALUE;
                }
                if(ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && n < -8)){
                    return Integer.MIN_VALUE;
                }
                ans = ans * 10 + n;
                i++;
            }
            return ans;
    
        }
    }
}
