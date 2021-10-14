package com.review;

//91. Decode Ways
public class Q91 {
    public static void main(String[] args) {
        Q91 test=new Q91();
        int a=test.numDecodings("10");
        System.out.println(a);
    }
    public int numDecodings(String s) {
        int len=s.length();
        if(len==0) return 0;
        int[] dp=new int[len+1];
        dp[0]=1;
        for (int i = 1; i <= len; i++) {
            if(s.charAt(i-1)!='0'){
                dp[i]+=dp[i-1];
            }
            if(i>1&&s.charAt(i-2)!=0&&((s.charAt(i-2)-'0')*10+s.charAt(i-1)-'0')<=26){
                dp[i]+=dp[i-2];
            }
        }
        return dp[len];
    }
}
