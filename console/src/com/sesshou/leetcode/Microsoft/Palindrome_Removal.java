package com.sesshou.leetcode.Microsoft;

/**
 * @author wp41128
 * @date 2020/6/23 10:09
 * @description：删除回文子数组
 */
public class Palindrome_Removal {
    public static void main(String[] args) {
        Palindrome_Removal test=new Palindrome_Removal();
        int[] arr=new int[]{1,3,4,1,5};
        System.out.println(test.minimumMoves(arr));
    }
    public int minimumMoves(int[] arr) {
        int len=arr.length;
        int[][] dp=new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i]=1;
        }
        for (int i = 0; i < len-1 ; i++) {
            dp[i][i+1]=arr[i]==arr[i+1]?1:2;
        }
        for (int j = 2; j < len; j++) {
            for (int i = j-2; i >=0 ; i--) {
                int min=len;
                if(arr[i]==arr[j]) min=dp[i+1][j-1];
                for (int k = i; k<j ; k++) {
                    min=Math.min(min,dp[i][k]+dp[k+1][j]);
                }
                dp[i][j]=min;
            }
        }
        return dp[0][len-1];
    }

    public int minimumMovesV2(int[] arr) {
        int len=arr.length;
        int[][] dp=new int[len][len];
        for (int j = 0; j < len ; j++) {
            for (int i = j; i >=0 ; i--) {
                if(i==j) dp[i][j]=1;
                else if(i+1==j) dp[i][j]=arr[i]==arr[j]?1:2;
                else {
                    int min=len;
                    if(arr[i]==arr[j]) min=dp[i+1][j-1];
                    for (int k = i; k<j ; k++) {
                        min=Math.min(min,dp[i][k]+dp[k+1][j]);
                    }
                    dp[i][j]=min;
                }
            }
        }
        return dp[0][len-1];


    }
}
