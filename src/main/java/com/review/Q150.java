package com.review;

import java.util.*;


//150. Evaluate Reverse Polish Notation

public class Q150 {
    private List<String> dicts= Arrays.asList(new String[]{"+","-","*","/"});
    public int evalRPN(String[] tokens) {
        int len=tokens.length;
        if(len==0) return 0;
        int result=new Integer(tokens[0]);
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i < len; i++) {
            if(dicts.contains(tokens[i])){
                Integer q=stack.pop();
                Integer p=stack.pop();
                switch (tokens[i]){
                    case "+":
                        result=q+p;
                        break;
                    case "-":
                        result=p-q;
                        break;
                    case "*":
                        result=q*p;
                        break;
                    case "/":
                        result=p/q;
                        break;
                }
                stack.push(result);
            }else{
                stack.push(new Integer(tokens[i]));
            }
        }
        return result;
    }
}
