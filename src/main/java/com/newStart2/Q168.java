package com.newStart2;

public class Q168 {
    public static void main(String[] args) {
        Q168 test=new Q168();
        test.convertToTitle(701);
    }
    public String convertToTitle(int n) {
        StringBuilder s=new StringBuilder("");
        //余数为0的时候其实是对应的是Z 因为没有0 所以只能往前退一位
        while (n>0){
            n--;
            s.append((char)(n%26+'A'));
            n/=26;
        }
        return s.reverse().toString();
    }
}
