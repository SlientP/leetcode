package com.review;

import java.util.Stack;

//71. Simplify Path
//用栈
// .->当前路径 ..->上一路径
public class Q71 {
    public String simplifyPath(String path) {
        String[] arrays=path.split("/");
        Stack<String> stack=new Stack<>();
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
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop());
            sb.insert(0, "/");
        }
        return sb.toString();
    }
}
