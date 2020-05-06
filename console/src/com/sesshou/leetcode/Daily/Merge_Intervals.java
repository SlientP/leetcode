package com.sesshou.leetcode.Daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author wp41128
 * @date 2020/4/16 16:56
 * @description：合并范围
 */
public class Merge_Intervals {
    public static void main(String[] args) {
        Merge_Intervals test=new Merge_Intervals();
        int[][] nums=new int[][]{{1,4},{4,5}};
        System.out.println(test.merge(nums));
    }
    public int[][] merge(int[][] nums) {
        int max = getMax(nums);
        int[] array = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            fillArray(array, nums[i][0], nums[i][1]);
        }
        List<Integer> index=new ArrayList<Integer>();
        int L=0;
        while (L<array.length){
            if(array[L]==1){
                if(index.size()%2==0) index.add(L);
                else {
                    while (L+1<array.length&&array[L+1]==1)L++;
                    index.add(L);
                }
            }
            L++;
        }


        int[][] result=new int[index.size()/2][2];
        for (int i = 0; i < index.size(); i++) {
            result[i/2][i%2]=index.get(i);
        }
        return result;
    }

    private int getMax(int[][] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                max = Math.max(max, nums[i][j]);
            }
        }
        return max;
    }

    private void fillArray(int[] array, int i, int j) {
        for (int k = i; k <= j; k++) {
            array[k] += 1;
        }
    }
}
