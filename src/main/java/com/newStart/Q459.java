package com.newStart;

//s的长度n
//从2到n/2 在整除的情况下进行字符串划分
//如果成功则返回ture
public class Q459 {
    public static void main(String[] args) {
        Q459 test=new Q459();
        System.out.println(test.repeatedSubstringPattern("abab"));
    }
    public boolean repeatedSubstringPattern(String s) {
        int len=s.length();
        if(len==1) return false;
        for (int i = len/2; i >=1 ; i--) {
            if(len%i==0){
                if(s.replaceAll(s.substring(0,i),"").isEmpty()) return true;
            }
        }
        return false;
    }
}
