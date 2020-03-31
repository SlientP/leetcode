package com.sesshou.leetcode.Array;

/**
 * @author wp41128
 * @date 2020/3/31 7:37
 * @description：
 */
public class Search_Insert_Position {
    public static void main(String[] args) {
        Search_Insert_Position test=new Search_Insert_Position();
        int[] nums=new int[]{1,3};
        System.out.println(test.searchInsert(nums,2));
    }
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0] == target ? 0 : nums[0] > target ? 0 : 1;
        int L = 0;
        int R = len - 1;
        int index = 0;
        int minvalue = Integer.MAX_VALUE;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (target == nums[mid]) return mid;
            else if (target > nums[mid]) L = mid + 1;
            else R = mid - 1;
            if (Math.abs(nums[mid] - target) < minvalue) {
                minvalue = Math.abs(nums[mid] - target);
                index = mid;
            }
        }
        return nums[index] > target ? index : index + 1;
    }
}
