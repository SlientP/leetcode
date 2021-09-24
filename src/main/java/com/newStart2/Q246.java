package com.newStart2;

public class Q246 {
    public boolean isStrobogrammatic(String num) {
        int len=num.length();
        if(len==0) return false;
        if(len==1) return num.equals("1")||num.equals("8")||num.equals("0");
        int L=0;
        int R=len-1;
        while (L<=R){
            if(!isP(num.charAt(L),num.charAt(R))) return false;
            L++;R--;
        }
        return true;
    }
    private boolean isP(char a,char b){
        if(a=='9') return b=='6';
        if(a=='6') return b=='9';
        if(a=='8') return b=='8';
        if(a==b){
            return a=='1'||a=='8'||a=='0';
        }
        return false;
    }


}
