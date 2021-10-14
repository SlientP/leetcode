package com.review;

//9. Palindrome Number
public class Q9 {
    public boolean isPalindrome(int x) {
        int result=0;
        if(x<0) return false;
        while(x>result){
            result=result*10+x%10;
            //x=10
            if(result==0) return false;
            x=x/10;
        }
        return x==result||result/10==x;
    }
}
