package com.review;

//541. Reverse String II --Q344、Q557
public class Q541 {
    public String reverseStr(String s, int k) {
        int len=s.length();
        char[] ss=s.toCharArray();
        int L=0,R=2*k;
        while(L<len){
            if(R<len||L+k<len){
                swap(ss,L,L+k-1);
            }else{
                swap(ss,L,len-1);
            }
            L=R;R=R+2*k;
        }
        return new String(ss);
    }

    private void swap(char[] s,int L,int R){
        while(L<R){
            char temp=s[L];
            s[L]=s[R];
            s[R]=temp;
            L++;R--;
        }
    }
}
