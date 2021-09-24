package com.sesshou.leetcode.Array;

/**
 * @author wp41128
 * @date 2020/4/1 8:13
 * @description： Trapping Rain Water
 */
public class Trapping_Rain_Water {
    public static void main(String[] args) {
        Trapping_Rain_Water test=new Trapping_Rain_Water();
        int[] nums=new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        test.trap(nums);
    }
    public int trap(int[] height) {
        int res=0;
        int len=height.length;
        for (int i = 1; i <len-1 ; i++) {
            int max_left = 0, max_right = 0;
            for (int j = i; j >= 0; j--) { //Search the left part for max bar size
                max_left = Math.max(max_left, height[j]);
            }
            for (int j = i; j < len; j++) { //Search the right part for max bar size
                max_right = Math.max(max_right, height[j]);
            }
            res += Math.min(max_left, max_right) - height[i];

        }
        return res;
    }
}
