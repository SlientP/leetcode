package com.newStart;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//Valid Parentheses
//需要考虑stack为空的情况 栈取值的情况下 要考虑下
public class Q20 {

    public static void main(String[] args) {
        Q20 test=new Q20();
        System.out.println(test.isValid("]"));
    }


    private Map<Character,Character> maps=new HashMap<Character, Character>(){{
        put(')','(');put(']','[');put('}','{');
    }};

    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<Character>();
        int len=s.length();
        for (int i = 0; i < len; i++) {
            if(maps.keySet().contains(s.charAt(i))){
                if(!stack.isEmpty()&&stack.peek()==maps.get(s.charAt(i))){
                    stack.pop();
                }else{
                    return false;
                }
            }else stack.push(s.charAt(i));
        }
        return stack.isEmpty();
    }
}
