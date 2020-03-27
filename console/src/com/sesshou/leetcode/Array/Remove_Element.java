package com.sesshou.leetcode.Array;

/**
 * @author wp41128
 * @date 2020/3/27 9:46
 * @description：
 */
public class Remove_Element {
    public static void main(String[] args) {
        int[] nums=new int[]{3,2,2,3};
        int val=3;
        System.out.println(removeElement(nums,val));
    }
    public static int removeElement(int[] nums, int val) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int L = 0;
        int R = 0;
        while (R < len) {
            while (R < len && nums[R] == val) R++;
            if(R<len) {
                nums[L] = nums[R];
                L++;
                R++;
            }
        }
        return L ;
    }
}
