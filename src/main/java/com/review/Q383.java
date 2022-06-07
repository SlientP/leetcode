package com.review;

import java.util.*;

public class Q383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> dic=new HashMap();
        for (int i = 0; i < magazine.length(); i++) {
            char key=magazine.charAt(i);
            dic.put(key, dic.getOrDefault(key,0)+1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char key=ransomNote.charAt(i);
            if(!dic.keySet().contains(key)) return false;
            else{
                int count=dic.get(key);
                if(count==0) return false;
                else dic.put(key, count-1);
            }
        }
        return true;
    }

    //只是使用了有限的空间来做这一道题
    public boolean canConstructV2(String ransomNote, String magazine) {
        int len1=ransomNote.length();
        int len2=magazine.length();
        int arr1[]=new int[26];
        int arr2[]=new int[26];
        for(int i=0;i<len1;i++){
            arr1[ransomNote.charAt(i)-97]++;
        }
        for(int i=0;i<len2;i++){
            arr2[magazine.charAt(i)-97]++;
        }
        for (int i = 0; i < 26; i++) {
            if (arr2[i] - arr1[i]<0) {
                return false;
            }
        }return true;
    }


}
