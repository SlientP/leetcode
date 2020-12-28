package com.newStart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Q49 {
    public static void main(String[] args) {
        Q49 test=new Q49();
        String[] strs=new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result= test.groupAnagrams(strs);
        for (List<String> item: result) {
            for (String item_s:item) {
                System.out.print(item_s);
            }
            System.out.println("");
        }
    }
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
            String key= Arrays.toString(array);
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
