package com.newStart;

//Implement strStr()
public class Q28 {
    public static void main(String[] args) {
        Q28 test=new Q28();
        System.out.println(test.strStr("mississippi","issip"));
    }
    public int strStr(String haystack, String needle) {
        int len1=haystack.length();
        int len2=needle.length();
        if(len2==0) return 0;
        int i=0;
        int j=0;
        while (i<len1&&i+len2-1<len1){
            while (i<len1&&j<len2&&haystack.charAt(i)==needle.charAt(j)){
                i++;j++;
            }
            if(j==len2){
                return i-len2;
            }else{
                i=i-j;i++;j=0;
            }
        }
        return -1;
    }
}
