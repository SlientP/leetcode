package com.newStart;

public class Q45 {

    public static void main(String[] args) {
        Q45 test=new Q45();
        int[] nums=new int[]{1,2,3};
        test.jump(nums);
    }
    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }


}
