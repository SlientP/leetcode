package com.newStart2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
//AAAAA AAAAAA
public class Q187 {
    public static void main(String[] args) {
        Q187 test=new Q187();
        test.findRepeatedDnaSequences("AAAAAAAAAAA");
    }
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String,Integer> result=new HashMap<>();
        int len=s.length();
        if(len<10) return new ArrayList<>(result.keySet());
        HashMap<String,Integer> map=new HashMap<>();
        for (int i = 0; i <= len-10; i++) {
            if(map.isEmpty()||!map.containsKey(s.substring(i,i+10))){
                map.put(s.substring(i,i+10),i);
            }else{
                result.put(s.substring(i,i+10),i);
            }
        }
        return new ArrayList<>(result.keySet());
    }
}
