package com.newStart2;

public class Q172 {
    //只关注5的倍数 因为5的阶乘有
    // 5 2*5   1
    // 10 2*5*10 2
    // 15 2*5*10*12*15 3
    // 20 2*5*10*12*15*20 4
    // 25 2*5*10*12*15*20*22*24*25 6

    public int trailingZeroes(int n) {
        int zeroCount = 0;
        for (int i = 5; i <= n; i += 5) {
            int currentFactor = i;
            while (currentFactor % 5 == 0) {
                zeroCount++;
                currentFactor /= 5;
            }
        }
        return zeroCount;
    }
}
