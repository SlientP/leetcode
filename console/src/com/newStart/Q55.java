package com.newStart;

public class Q55 {

    public static void main(String[] args) {
        Q55 test = new Q55();
        int[] nums = new int[]{2, 3, 1, 1, 4};
        System.out.println(test.canJump(nums));
    }

    public boolean canJump(int[] nums) {
        int len = nums.length;
        if (len == 0) return false;
        int max = 0;
        for (int i = 0; i < len; i++) {
            if (max >= i) max = Math.max(i + nums[i], max);
        }
        return max >= len - 1;
    }
}


