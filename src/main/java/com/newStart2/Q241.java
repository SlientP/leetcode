package com.newStart2;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2021/4/13 0013.
 */
public class Q241 {
    public static void main(String[] args) {
        Q241 test=new Q241();
        test.diffWaysToCompute("11");
    }
    public List<Integer> diffWaysToCompute(String expression) {
        if(expression.length()==0){
            return new ArrayList<>();
        }
        List<Integer> result=new ArrayList<>();
        int index=0;
        int num=0;
        while (index<expression.length()&&!isOperator(expression.charAt(index))){
            num=num*10+expression.charAt(index)-'0';
            index++;
        }
        if(index==expression.length()){
            result.add(num);
            return result;
        }
        for (int i = 0; i < expression.length() ; i++) {
            if(isOperator(expression.charAt(i))) {
                List<Integer> L = diffWaysToCompute(expression.substring(0, i));
                List<Integer> R=diffWaysToCompute(expression.substring(i+1));
                for (int j = 0; j <L.size() ; j++) {
                    for (int k = 0; k <R.size();  k++) {
                        result.add(cal(L.get(j),expression.charAt(i),R.get(k)));
                    }
                }
            }
        }
        return result;
    }
    private int cal(int num1,char operator,int num2){
        switch (operator){
            case '+':
                return num1+num2;
            case '-':
                return num1-num2;
            case '*':
                return num1*num2;
        }
        return -1;
    }
    private boolean isOperator(char c){
        return c=='+'||c=='-'||c=='*';
    }
}
