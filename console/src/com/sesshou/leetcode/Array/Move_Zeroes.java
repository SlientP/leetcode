package com.sesshou.leetcode.Array;

/**
 * Created by Administrator on 2020/4/13 0013.
 */
public class Move_Zeroes {
    public static void main(String[] args) {
        Move_Zeroes test=new Move_Zeroes();
        int[] nums=new int[]{0,1,0,3,12};
        test.moveZeroes(nums);
        System.out.println("1243");
    }
    public void moveZeroes(int[] nums) {
        int len=nums.length;
        if(len==0||len==1) return;
        int L=0;
        int R=L+1;
        while (R<len){
            if(nums[L]==0){
                while (nums[R]==0&&R<len-1) R++;
                int temp = nums[L];
                nums[L] = nums[R];
                nums[R] = temp;
            }
            L++;
            R++;
        }
    }
}
