package com.newStart;

import java.util.ArrayList;
import java.util.List;

//Generate Parentheses
public class Q22 {
    public static void main(String[] args) {
        Q22 test=new Q22();
        List<String> result=test.generateParenthesis(3);
        System.out.println("123");
    }
    List<String> result=new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        if(n!=0){
            generate(n-1,n,"(");
        }
        return result;
    }

    private void generate(int i,int j,String s){
        if(i>0||j>0){ //还有括号要添加
            if(j>i) {
                if(i>0) { //还有(需要添加
                    generate(i - 1, j, s+("("));
                    generate(i,j-1,s+(")"));
                }else generate(i,j-1,s+(")")); //只需要添加)
            }else{//i==j时必须先添加（
                generate(i-1,j,s+("("));
            }
        }else result.add(s);
    }
}
