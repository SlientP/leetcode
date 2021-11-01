package com.review;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

//557. Reverse Words in a String III --Q344、Q541
public class Q557 {
    public static void main(String[] args) {
        String s="Let's take LeetCode contest";
        Q557 test=new Q557();
        test.reverseWords(s);
    }
    public String reverseWords(String s) {
        String[] ss=s.split(" ");
        List<String> list=new ArrayList<>();
        for (String string : ss) {
            String temp=reverseString(string);
            list.add(temp);
        }
        return list.stream().collect(Collectors.joining(" "));
    }

    public String reverseString(String ss) {
        int len=ss.length();
        if(len==0) return "";
        char[] s=ss.toCharArray();
        int L=0,R=len-1;
        while(L<R){
            char temp=s[L];
            s[L]=s[R];
            s[R]=temp;
            L++;R--;
        }
        return new String(s);
    }
}
