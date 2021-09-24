package com.newStart2;


import java.util.ArrayList;
import java.util.List;

public class Q242 {
    public boolean isAnagram(String s, String t) {
        int slen=s.length();
        int tlen=t.length();
        if(slen!=tlen) return false;
        if(slen==0) return true;
        List<Character> temp=new ArrayList<>();
        for (int i = 0; i < slen; i++) {
            temp.add(s.charAt(i));
        }
        for (int i = 0; i < tlen; i++) {
            temp.remove(new Character(t.charAt(i)));
        }
        return temp.size()==0;
    }
}
