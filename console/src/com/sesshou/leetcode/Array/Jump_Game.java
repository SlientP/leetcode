package com.sesshou.leetcode.Array;

/**
 * Created by Administrator on 2020/4/8 0008.
 */
public class Jump_Game {
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
    public int jump(int[] nums) {
        int lastPos = nums.length - 1;
        int[] index=new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                index[i] = 1;
                lastPos = i;
            }
        }
        if(lastPos == 0) return 1;
        return 0;
    }

}
