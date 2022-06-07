package com.newStart2;

import java.util.Arrays;
import java.util.HashSet;

public class Q834 {
    
    public static void main(String[] args){
        Q834 test=new Q834();
        String s=test.toGoatLatin("The quick brown fox jumped over the lazy dog");
        System.out.println(s);
    }

    private HashSet<Character> set=new HashSet<Character>() {{
        add('a');
        add('e');
        add('i');
        add('o');
        add('u');
        add('A');
        add('E');
        add('I');
        add('O');
        add('U');
    }};

    public String toGoatLatin(String sentence) {
        int length=sentence.length();
        if(length==0) return sentence;
        String[] ss=sentence.split(" ");
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<ss.length;i++){
            sb.append(doit(ss[i],i+1));
            if(i!=ss.length-1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
    private String doit(String s,int i){
        StringBuilder sb=new StringBuilder();
        if(set.contains(s.charAt(0))){
            sb.append(s);
        }else{
            sb.append(s.substring(1)).append(s.charAt(0));
        }

        sb.append("ma");
        while(i>0){
            sb.append("a");
            i--;
        }
        return sb.toString();
    }
}
