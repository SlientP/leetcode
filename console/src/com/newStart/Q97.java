package com.newStart;

public class Q97 {
    public static void main(String[] args) {
        Q97 test=new Q97();
        System.out.println(test.isInterleave("aabcc","dbbca","aadbbcbcac"));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int len1=s1.length();
        int len2=s2.length();
        int len3=s3.length();
        if(len1+len2!=len3) return false;
        int[][] dp=new int[len3][2];

        int m=0;
        int n=0;
        dp[0][0]=s1.charAt(0)==s3.charAt(0)?1:0;
        dp[0][1]=s2.charAt(0)==s3.charAt(0)?1:0;
        for (int i = 1; i < len3; i++) {
            if(dp[i-1][0]<len1&&s1.charAt(dp[i-1][0])==s3.charAt(i)){
                dp[i][0]=dp[i-1][0]++;
            }else if(dp[i-1][1]<len2&&s2.charAt(dp[i-1][1])==s3.charAt(i)){
                dp[i][1]=dp[i-1][1]++;
            }else return false;
        }
        return true;
    }



    //out of time
    public boolean isInterleaveV1(String s1, String s2, String s3) {
        int len1=s1.length();
        int len2=s2.length();
        int len3=s3.length();
        if(len1+len2!=len3) return false;
        return dfs(s1,s2,s3,0,0,0);
    }
    private boolean dfs(String s1,String s2,String s3,int i,int j,int k){
        if(i==s1.length()&&j==s2.length()&&k==s3.length()) return true;
        boolean b1=false;
        boolean b2=false;
        if(i<s1.length()&&s1.charAt(i)==s3.charAt(k)){
            b1=dfs(s1,s2,s3,i+1,j,k+1);
        }
        if(j<s2.length()&&s2.charAt(j)==s3.charAt(k)){
            b2=dfs(s1,s2,s3,i,j+1,k+1);
        }
        return b1||b2;
    }
}
