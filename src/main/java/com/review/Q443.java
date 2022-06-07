package com.review;

public class Q443 {
    public static void main(String[] args) {
        char[] chars=new char[]{'a','a','b','b','c','c','c'};
        Q443 test=new Q443();
        test.compress(chars);
    }
    public int compress(char[] chars) {
        int len=chars.length;
        int L=0;int R=0;
        int index=0;
        while(R<len){
            while(R<len&&chars[R]==chars[L]) R++;
            chars[index]=chars[L];
            index++;
            int count=R-L;
            if(count>1) {
                int anchor=index;
                while(count>0){
                    chars[index]=(char)(count%10+'0');
                    count=count/10;
                    index++;
                }
                reverse(chars, anchor, index - 1);
            }
            L=R;
        }
        return index;
    }

    public void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
