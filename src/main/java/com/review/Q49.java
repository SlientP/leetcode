package com.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//使用HashMap<String,List<String>>来记录相同的字符串
//使用array来记录相同的字符串中字符的位置
public class Q49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result=new ArrayList<>();
        int n=strs.length;
        if(n==0) return result;
        HashMap<String,List<String>> map=new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s=strs[i];
            int len=s.length();
            int[] array=new int[26];
            for (int j = 0; j < len; j++) {
                array[s.charAt(j)-97]++;
            }
            String key=Arrays.toString(array);
            if(map.isEmpty()||!map.containsKey(key)){
                List<String> item=new ArrayList<>();
                item.add(s);
                map.put(key,item);
            }else if(map.containsKey(key)){
                List<String> item=map.get(key);
                item.add(s);
            }
        }
        for (String key:map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }
}
