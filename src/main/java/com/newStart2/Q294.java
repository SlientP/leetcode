package com.newStart2;

public class Q294 {
    public static void main(String[] args) {
        Q294 test=new Q294();
        test.canWin("++++");
    }
    public boolean canWin(String currentState) {
        int len=currentState.length();
        if(len<=1) return false;
        int i=1;
        char[] arr=currentState.toCharArray();
        boolean result=false;
        while (i<len){
            if(arr[i]==arr[i-1]&&arr[i]=='+'){
                arr[i]=arr[i-1]='-';
                result=result || !canWin(new String(arr));
                arr[i]=arr[i-1]='+';
            }
            i++;
            if(result) return result;
        }
        return false;
    }


}
