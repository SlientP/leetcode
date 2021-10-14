package com.review;

// 7. Reverse Integer
// Example 1:

// Input: x = 123
// Output: 321
// Example 2:

// Input: x = -123
// Output: -321
// Example 3:

// Input: x = 120
// Output: 21
// Example 4:

// Input: x = 0
// Output: 0


public class Q7 {
    public int reverse(int x) {
        int result=0;
        while(x!=0){
            int temp=x%10;
            if(result>Integer.MAX_VALUE/10||result<Integer.MIN_VALUE/10) return 0;
            result=result*10+temp;
            x=x/10;
        }
        return result;
    }
}
