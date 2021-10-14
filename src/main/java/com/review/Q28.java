package com.review;

//28. Implement strStr()
public class Q28 {
    public int strStr(String haystack, String needle) {
        int len1=haystack.length();
        int len2=needle.length();
        if(len2==0) return 0;
        int i=0;int j=0;
        while(i<len1&&i+len2-1<len1){
            while (i<len1&&j<len2&&haystack.charAt(i)==needle.charAt(j)){
                i++;j++;
            }
            //如果遍历到末尾则成功
            //否则i 退回起始位置 然后++
            if(j==len2){
                return i-len2;
            }else{
                i=i-j;i++;j=0;
            }
        }
        return -1;
    }
}
