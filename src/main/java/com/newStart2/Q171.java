package com.newStart2;

public class Q171 {
    public int titleToNumber(String s) {
        int len=s.length();
        if(len==0) return 0;
        int result=0;
        for (int i = 0; i < len ; i++) {
            char temp=s.charAt(i);
            result=result*26+(temp-'@');
        }
        return result;
    }
}
