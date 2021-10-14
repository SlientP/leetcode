package com.review;

//66. Plus One
public class Q66 {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            //不进位 其余位直接照抄
            //进位的话也就只能进1 下一位也增加
            if (digits[i] != 0) return digits;
        }
        //需要数组扩容的情况只能是 9,99,999，9999
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
