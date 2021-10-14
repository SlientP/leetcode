package com.review;

import java.util.ArrayList;
import java.util.List;

//22. Generate Parentheses
public class Q22 {
    List<String> result=new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        if(n!=0){
            generate(n-1,n,"(");
        }
        return result;
    }

    private void generate(int i,int j,String s){
        if(i>0||j>0){
            //i 代表"(" j代表")"
            if(j>i) {//代表")"剩下的比较多 随意补
                if(i>0) {
                    generate(i - 1, j, s+("("));
                    generate(i,j-1,s+(")"));
                }else generate(i,j-1,s+(")"));
            }else{
                generate(i-1,j,s+("("));
            }
        }else result.add(s.toString());
    }
}
