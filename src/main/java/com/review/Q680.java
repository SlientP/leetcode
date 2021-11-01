package com.review;

//680. Valid Palindrome II
public class Q680 {
    public static void main(String[] args) {
        String s="eeccccbebaeeabebccceea";
        Q680 test =new Q680();
        test.validPalindrome(s);
    }
    public boolean validPalindrome(String s) {
        int len=s.length();
        return isPalindrome(s, 0, len-1,true);
    }
    private boolean isPalindrome(String s,int L,int R,boolean flag){
        if(L>=R) return true;
        if(s.charAt(L)==s.charAt(R)) return isPalindrome(s, L+1, R-1,true);
        else return flag&&(isPalindrome(s, L+1, R,false)||isPalindrome(s, L, R-1,false));
    }
}
