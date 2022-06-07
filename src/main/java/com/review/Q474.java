package com.review;

import java.util.Arrays;

public class Q474 {
    public static void main(String[] args) {
        Q474 test=new Q474();
        String[] strs=new String[]{"10", "0001", "111001", "1", "0"};
        test.findMaxForm(strs, 5, 3);
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int length=strs.length;
        int[][] dp=new int[m+1][n+1];
        for (int i = 1; i <= length; i++) {
            int[] zones=getNumbers(strs[i-1]);
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <n ; k++) {
                    if(j>=zones[0]&&k>=zones[1]){
                        dp[j][k]=Math.max(dp[j][k], dp[j-zones[0]][k-zones[1]]+1);
                    }
                }                
            }
        }
        return dp[m][n];
    }

    private int[] getNumbers(String str){
        int[] result=new int[2];
        for (int i = 0; i < str.length(); i++) {
            result[str.charAt(i)-'0']++;
        }
        return result;
    }
}
