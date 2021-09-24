package com.newStart2;

import java.util.Arrays;

public class Q204 {
    public int countPrimes(int n) {
        int count=0;
        int[] array=new int[n];
        Arrays.fill(array,1);
        for (int i = 2; i < n; i++) {
            if(array[i]==1){
                count++;
                if((long)i*i<n){
                    for (int j = i*i; j < n; j+=i) {
                        array[j]=0;
                    }
                }
            }
        }
        return count;
    }
}
