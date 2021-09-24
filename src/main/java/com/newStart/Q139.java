package com.newStart;

import java.util.ArrayList;
import java.util.List;

public class Q139 {
    public static void main(String[] args) {
        Q139 test=new Q139();
        List<String> wordDict=new ArrayList<String>(){{
            add("leet");add("code");
        }};
        System.out.println(test.wordBreak("leetcode",wordDict));
    }
    //"acaaaaabbbdbcccdcdaadcdccacbcccabbbbcdaaaaaadb"
    //["abbcbda","cbdaaa","b","dadaaad","dccbbbc","dccadd","ccbdbc","bbca","bacbcdd","a","bacb","cbc","adc","c","cbdbcad","cdbab","db","abbcdbd","bcb","bbdab","aa","bcadb","bacbcb","ca","dbdabdb","ccd","acbb","bdc","acbccd","d","cccdcda","dcbd","cbccacd","ac","cca","aaddc","dccac","ccdc","bbbbcda","ba","adbcadb","dca","abd","bdbb","ddadbad","badb","ab","aaaaa","acba","abbb"]
    //timeout
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length()==0) return true;

        boolean temp=false;
        for (String item: wordDict) {
            if(s.startsWith(item)){
                temp=wordBreak(s.replaceFirst(item,""),wordDict)||temp;
            }
        }
        return temp;
    }

    public boolean wordBreakV2(String s,List<String> wordDict){
        int len=s.length();
        boolean[] dp=new boolean[len+1];
        dp[0]=true;
        for (int i = 1; i <= s.length() ; i++) {
            for (int j = 0; j < i; j++) {
                if(dp[j]&& wordDict.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[len];
    }
}
