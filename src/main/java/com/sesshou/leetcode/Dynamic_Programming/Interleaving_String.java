package com.sesshou.leetcode.Dynamic_Programming;

/**
 * @author wp41128
 * @date 2020/6/16 15:55
 * @description：
 */
public class Interleaving_String {
    public static void main(String[] args) {
        Interleaving_String test=new Interleaving_String();
        System.out.println(test.isInterleaveV2("aabcc",
                "dbbca",
                "aadbbcbcac"));
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1=s1.length();
        int len2=s2.length();
        int len3=s3.length();
        if(len1+len2!=len3) return false;
        if(len3==0) return true;
        else{
            if(len3==1){
                if(len1==1) return s3.charAt(0)== s1.charAt(0);
                else return s3.charAt(0)== s2.charAt(0);
            }
            boolean b1=false;
            boolean b2=false;
            if(len1>0&&s3.charAt(len3-1)==s1.charAt(len1-1)){
                b1=isInterleave(s1.substring(0,len1-1),s2,s3.substring(0,len3-1));
            }
            if(len2>0&&s3.charAt(len3-1)==s2.charAt(len2-1)){
                 b2=isInterleave(s1,s2.substring(0,len2-1),s3.substring(0,len3-1));
            }
            return b1||b2;
        }

    }
    public boolean isInterleaveV2(String s1, String s2, String s3) {
        int len1=s1.length();
        int len2=s2.length();
        int len3=s3.length();
        if(len1+len2!=len3) return false;
        if(len3==0) return true;
        boolean[][] dp=new boolean[len1+1][len2+1];
        for (int i = 0; i < len1+1; i++) {
            for (int j = 0; j < len2+1; j++) {
                if(i==0&&j==0) dp[0][0]=true;
                else if(i==0) dp[i][j]=dp[i][j-1]&&s3.charAt(i+j-1)==s2.charAt(j-1);
                else if(j==0) dp[i][j]=dp[i-1][j]&&s3.charAt(i+j-1)==s1.charAt(i-1);
                else{
                    dp[i][j]=(dp[i][j-1]&&s3.charAt(i+j-1)==s2.charAt(j-1))||(dp[i-1][j]&&s3.charAt(i+j-1)==s1.charAt(i-1));
                }
            }
        }
        return dp[len1][len2];

    }
}
