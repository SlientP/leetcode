package com.newStart2;

public class Q313 {
    public static void main(String[] args) {
        int[] primes=new int[]{2,7,13,19};
        Q313 test=new Q313();
        System.out.println(test.nthSuperUglyNumber(12,primes));
    }
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] result=new int[n];
        if(n==1) return 1;
        result[0]=1;
        result[1]=primes[0];
        int len=primes.length;

        int j=1;
        int k=1;
        for (int i = 2; i < n; i++) {
            int temp=primes[0]*result[k];
            if(j<len&&temp>primes[j]) {
                result[i] = primes[j];
                j++;
            }
            else {
                result[i] = temp;
                k++;
            }
        }
        for (int i = 0; i < n+1; i++) {
            System.out.println(result[i]);
        }
        return result[n-1];
    }
}


