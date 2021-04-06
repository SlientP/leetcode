package com.newStart2;
//>>是向左移
public class Q190 {
    public static void main(String[] args) {
        Q190 test=new Q190();
        //test.reverseBits(4294967293);
    }
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;
        for(int i = 0; i < 32; i++) {
            //二进制最后一位bit
            int bit = n&1;
            //右移一位
            n = n >> 1;
            //ans左移一位加上bit
            ans = (ans << 1) + bit;
        }
        return ans;
    }
}
