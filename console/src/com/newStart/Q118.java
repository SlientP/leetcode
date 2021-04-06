package com.newStart;

import java.util.ArrayList;
import java.util.List;

public class Q118 {
    public static void main(String[] args) {
        Q118 test=new Q118();
        List<List<Integer>> res= test.generate(5);
        System.out.println(1);
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<>();
        int i=1;
        while (i<=numRows){
            res.add(triangle(res,i));
            i++;
        }
        return res;
    }
    private List<Integer> triangle(List<List<Integer>> res,int numRows){
        if(numRows==1) return new ArrayList<Integer>(){{
            add(1);
        }};
        else if(numRows==2) return new ArrayList<Integer>(){{
            add(1);add(1);
        }};
        else{
            List<Integer> temp=new ArrayList<>();
            List<Integer> item=res.get(numRows-2);
            for (int i = 0; i < item.size()-1; i++) {
                temp.add(item.get(i)+item.get(i+1));
            }
            temp.add(1);
            temp.add(0,1);
            return temp;
        }
    }
}
