package com.Daily;



public class Q877 {
    public static void main(String[] args) {
        Q877 test=new Q877();
        int[] nums=new int[]{5,3,4,5};
        test.stoneGame(nums);
    }
    public boolean stoneGame(int[] piles) {
        int len=piles.length;
        int L=0;
        int R=len-1;
        int count=0;
        int A=0;int B=0;
        while (count<len){
            if(count%2==0) A+=piles[L]>=piles[R]?piles[L++]:piles[R--];
            else B+=piles[L]>=piles[R]?piles[L++]:piles[R--];
            count++;
        }
        return A>B;
    }
}
