package com.sesshou.leetcode.Array;

/**
 * @author wp41128
 * @date 2020/4/16 18:38
 * @description：
 */
public class Max_Chunks_To_Make_Sorted {
    public static void main(String[] args) {
        Max_Chunks_To_Make_Sorted test =new Max_Chunks_To_Make_Sorted();
        //2,0,1
        //1,0,2,3,4
        //1,2,0,3,4
        //1,0,2
        //4,3,2,1,0
        //2,4,1,5,0,7,6
        int[] nums=new int[]{1,0,2,3,4};
        System.out.println(test.maxChunksToSorted(nums));
    }
    public int maxChunksToSorted(int[] nums) {
        int len=nums.length;
        if(len==0) return 0;
        if(len==1) return 1;
        int[][] minMax=new int[2][len];
        int maxIndex=0;
        int minIndex=0;
        int count=0;
        int breakIndex=0;
        while (breakIndex<len) {
            for (int i = breakIndex; i < len; i++) {
                if( nums[i] < nums[minIndex]){
                    minIndex=i;
                }
                minMax[0][i]=minIndex;
                if(nums[i]>nums[maxIndex]){
                    maxIndex=i;
                }
                minMax[1][i]=maxIndex;
            }
            breakIndex=minMax[0][len-1];
            while (breakIndex<len&&minMax[0][breakIndex]==breakIndex&&minMax[0][breakIndex]>minMax[1][breakIndex]) breakIndex++;
            breakIndex++;
            minIndex=breakIndex;
            maxIndex=breakIndex;
            count++;
        }
       return count;
    }
}
