package com.newStart;


//Count Binary Substrings
public class Q696 {
    public static void main(String[] args) {
        Q696 test=new Q696();
        System.out.println(test.countBinarySubstrings("00100"));
    }
    public int countBinarySubstrings(String s) {
        int count=0;
        int len=s.length();
        for (int i = 0; i < len-1; i++) {
            if((s.charAt(i)=='1'&&s.charAt(i+1)=='0')
            ||(s.charAt(i)=='0'&&s.charAt(i+1)=='1')){
                count++;
                int L=i;int R=i+1;
                while (L-1>=0&&R+1<len&&s.charAt(L)==s.charAt(L-1)
                &&s.charAt(R)==s.charAt(R+1)){
                    count++;
                    L--;
                    R++;
                }
            }
        }
        return count;
    }
}
