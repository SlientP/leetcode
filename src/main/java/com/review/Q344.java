package com.review;

//344. Reverse String --Q541、Q557
public class Q344 {
    public void reverseString(char[] s) {
        int len=s.length;
        if(len==0) return;
        int L=0,R=len-1;
        while(L<R){
            char temp=s[L];
            s[L]=s[R];
            s[R]=temp;
            L++;R--;
        }
    }
    
}
