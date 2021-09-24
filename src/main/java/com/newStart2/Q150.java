package com.newStart2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Q150 {
    public static void main(String[] args) {
        Q150 test=new Q150();
        String[] tokens=new String[]{"4","13","5","/","+"};
        test.evalRPN(tokens);
    }
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
                        result=q-p;
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
