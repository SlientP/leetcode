package com.newStart2;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class Q159 {
    public static void main(String[] args) {
        Q159 test=new Q159();
        System.out.println(test.lengthOfLongestSubstringTwoDistinctV2("aac"));
    }
    //O（n2）超出内存限制
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int len=s.length();
        if(len==0) return 0;
        int[][] dp=new int[len][len];
        int result=2;
        char[] ss=s.toCharArray();
        for (int i = 0; i < len; i++) {
            dp[i][i]=1;
        }
        for (int i = 0; i < len-1; i++) {
            if(ss[i]==ss[i+1]) {
                dp[i][i + 1] = 1;
            }else {
                dp[i][i+1]=2;
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = i + 2; j < len; j++) {
                if(dp[i][j-1]==1&&ss[i]==ss[j]) dp[i][j]=1;
                else if(dp[i][j-1]==1&&ss[i]!=ss[j]) dp[i][j]=2;
                else if(dp[i][j-1]==2&&s.substring(i,j).contains(String.valueOf(ss[j]))) dp[i][j]=2;
                else dp[i][j]=0;
                if(dp[i][j]==1||dp[i][j]==2){
                    result=Math.max(result,j-i+1);
                }
            }
        }
        return result;
    }
    //O(n)
    public int lengthOfLongestSubstringTwoDistinctV2(String s){
        int len=s.length();
        if(len<3) return len;
        int L=0;int R=0;
        int result=2;
        HashMap<Character,Integer> map=new HashMap<>();
        while (R<len) {
            if(map.size()<3){
                map.put(s.charAt(R),R);
                result=Math.max(R-L,result);
                R++;

            }else{
                int index= Collections.min(map.values());
                map.remove(s.charAt(index));
                L=index+1;
            }

        }
        return result;
    }
}
