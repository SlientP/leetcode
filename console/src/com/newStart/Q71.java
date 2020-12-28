package com.newStart;

import java.lang.reflect.Array;
import java.util.Stack;

public class Q71 {
    public static void main(String[] args) {
        Q71 test=new Q71();
        System.out.println(test.simplifyPath("/a/../../b/../c//.//"));
    }
    public String simplifyPath(String path) {
        String[] arrays=path.split("/");
        StringBuilder res=new StringBuilder("");
        Stack<String> stack=new Stack<String>();
        for (int i = 0; i < arrays.length; i++) {
            if(arrays[i].length()==0||arrays[i].equals(".")) continue;
            if(!stack.isEmpty()){
                if(arrays[i].equals("..")){
                    stack.pop();
                }else{
                    stack.push(arrays[i]);
                }
            }else{
                if(!arrays[i].equals("..")) stack.push(arrays[i]);
            }
        }
        if(stack.isEmpty()) return "/";
        while (!stack.isEmpty()){
            res.insert(0,stack.pop());
            res.insert(0,"/");
        }
        return res.toString();
    }
}
