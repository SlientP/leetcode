package com.newStart2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q163 {
    public static void main(String[] args) {
        Q163 test=new Q163();
        test.findMissingRanges(new int[]{-1},-1,0);
    }
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> list=new ArrayList<>();
        int len=nums.length;
        if(len==0) {
            String temp=find(lower-1,upper+1);
            list.add(temp);
        }
        else {
            int[] newnums=new int[len+2];
            for (int i = 0; i < len; i++) {
                String temp="";

            }
        }
        return list;
    }
    private String find(int i,int j){
        if(i==j||i==j-1) return "";
        else if(i==j-2) return String.valueOf(j-1);
        return i+1+"->"+(j-1);
    }
}
