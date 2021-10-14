package com.review;

public class Q67 {
    public String addBinary(String a, String b) {
        StringBuilder sb=new StringBuilder();
        int len1=a.length();
        int len2=b.length();
        int n=Math.max(len1,len2);
        int carry=0;
        for (int i = 0; i < n; i++) {
            carry+=i<len1?a.charAt(len1-i-1)-'0':0;
            carry+=i<len2?b.charAt(len2-i-1)-'0':0;
            sb.append(carry%2);
            if(carry>1) carry=1;
            else carry=0;
        }
         if(carry>0) sb.append(1);
         sb.reverse();
         return sb.toString();
    }
}
