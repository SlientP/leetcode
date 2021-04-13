package com.newStart2;

import sun.usagetracker.UsageTrackerClient;

import java.nio.charset.StandardCharsets;
import java.util.Stack;

public class Q227 {
    public static void main(String[] args) {
        Q227 test=new Q227();
        System.out.println(test.calculate("42"));

    }
    public int calculate(String s) {
        Stack<Integer> stack=new Stack<>();
        char operator='+';
        int num=0;
        int n=s.length();
        for (int i = 0; i < n; i++) {
            if(Character.isDigit(s.charAt(i))){
                num=num * 10+s.charAt(i)-'0';
            }
            if(!Character.isDigit(s.charAt(i))&&s.charAt(i)!=' '|| i==n-1){
                switch (operator){
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop()*num);
                        break;
                    case '/':
                        stack.push(stack.pop()/num);
                        break;
                }
                operator=s.charAt(i);
                num=0;
            }

        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}
