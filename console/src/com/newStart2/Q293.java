package com.newStart2;

import java.util.ArrayList;
import java.util.List;

public class Q293 {
    public List<String> generatePossibleNextMoves(String currentState) {
        List<String> result=new ArrayList<>();
        int len=currentState.length();
        if(len<1) return  result;
        int i=0; int j=1;
        char[] arr=currentState.toCharArray();
        while (j<len){
            if(arr[i]==arr[j]&&arr[i]=='+'){
                arr[i]=arr[j]='-';
                result.add(new String(arr));
                arr[i]=arr[j]='+';
            }
            i++;j++;
        }
        return result;
    }
}
