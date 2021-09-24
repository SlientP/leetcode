package com.microsoftInterview;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class Q1 {

    public static void main(String[] args) {
        Q1 test=new Q1();
        String[] ops=new String[]{"5","-2","4","C","D","9","+","+"};
        System.out.println(test.calPoints(ops));
        String[] words=new String[]{"time", "me", "bell"};
        test.minimumLengthEncoding(words);
    }
    public int minimumLengthEncoding(String[] words) {
        int len=words.length;
        StringBuilder sb=new StringBuilder();
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return t1.length()-s.length();
            }
        });
        for(int i=0;i<len;i++){
            if(sb.length()==0||sb.indexOf(words[i]+"#")==-1){
                sb.append(words[i]+"#");
            }
        }
        return sb.length();
    }
    public int calPoints(String[] ops) throws NumberFormatException  {
        int len=ops.length;
        if(len==0) return 0;
        Stack<Integer> s=new Stack<Integer>();
        for(int i=0;i<len;i++){

            if(ops[i].equals("C")) s.pop();
            else if(ops[i].equals("D")){
                Integer temp=s.peek();
                s.push(temp*2);
            }else if(ops[i].equals("+")){
                Integer a=s.pop();
                Integer b=s.pop();
                Integer temp=a+b;
                s.push(b);s.push(a);s.push(temp);
            }
            else s.push(new Integer(ops[i]));
        }
        int result=0;
        while (!s.isEmpty()){
            result+=s.pop();
        }
        return result;
    }
}
