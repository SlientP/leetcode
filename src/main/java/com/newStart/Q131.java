package com.newStart;

import java.util.ArrayList;
import java.util.List;

public class Q131 {
    public List<List<String>> partition(String s) {
        int n=s.length();
        boolean[][] dp=new boolean[n+1][n+1];
        for (int i = 0; i < n ; i++) {
            dp[i][i]=true;
            dp[i][i+1]=true;
        }
        dp[n][n]=true;
        for (int i = 1; i < n; i++) {
            for (int j = i; j >0 ; j--) {
                
            }
        }
        return new ArrayList<>();
    }
}
