package com.newStart;

import java.util.Arrays;

public class Q66 {
    public static void main(String[] args) {

    }
    public int[] plusOne(int[] digits) {
        int len=digits.length;
        int[] result=new int[len+1];
        int[] plus=new int[len];
        plus[len-1]=1;
        int temp=0;
        for (int i = len-1; i >=0 ; i--) {
            result[i]=digits[i]+plus[i]+temp;
            if(result[i]>=10){
                result[i]-=10;
                temp=1;
            }
        }
        if(result[0]==0) return Arrays.copyOfRange(result,1,len+1);
        return result;
    }
    public int[] plusOnev2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;//不进位 其余位直接照抄
        }
        //需要数组扩容的情况只能是 9,99,999，9999
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
    
}
