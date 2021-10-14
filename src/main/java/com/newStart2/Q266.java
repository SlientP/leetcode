package com.newStart2;


import java.util.HashSet;

public class Q266 {
    public boolean canPermutePalindrome(String s) {
        int len =s.length();
        if(len<=1) return true;
        HashSet<Character> set=new HashSet<>();
        for (int i = 0; i < len; i++) {
            if(set.isEmpty()||!set.contains(s.charAt(i))) set.add(s.charAt(i));
            else set.remove(s.charAt(i));
        }
        return set.size()<=1;
    }
}
