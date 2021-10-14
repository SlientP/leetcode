package com.review;

import java.util.Stack;
//20. Valid Parentheses
//使用栈匹配
public class Q20 {
    public boolean isValid(String s) {
        int len=s.length();
         if(len==0) return true;
        if(len==1) return false;
        Stack<Character> stack=new Stack<Character>();
        stack.push(s.charAt(0));
        for (int i = 1; i < len; i++) {
            Character c=s.charAt(i);
            if(stack.empty()){
                stack.push(c);
            }else if(Match(stack.peek(),c)){
                stack.pop();
            }else stack.push(c);
        }
        return stack.empty();
    }
    private boolean Match(Character c1,Character c2){
        if(c1.equals('(')&&c2.equals(')')){
            return true;
        }else if(c1.equals('{')&&c2.equals('}')){
            return true;
        }else if(c1.equals('[')&&c2.equals(']')){
            return true;
        }
        return false;
    }
}
