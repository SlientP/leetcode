package com.newStart;

public class Q14 {
    public static void main(String[] args) {
        Q14 test=new Q14();
        String[] strs=new String[]{"dog","racecar","car"};
        System.out.println(test.longestCommonPrefix(strs));
    }
    public String longestCommonPrefix(String[] strs) {
        int len=strs.length;
        if(len<=1) return"";
        String result=LongestCommonPrefixV2(strs[0],strs[1]) ;
        for(int i=2;i<strs.length;i++){
            if(result.equals("")) return  "";
            result=LongestCommonPrefixV2(strs[i],result);
        }
        return result;
    }
    private String LongestCommonPrefixV2(String s1,String s2){
        String result="";
        int n=Math.min(s1.length(),s2.length());
        int end=0;
        while(end<n&&s1.charAt(end)==s2.charAt(end)) end++;
        result=s1.substring(0,end);
        return result;
    }
}
