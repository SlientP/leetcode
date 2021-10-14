package com.review;

import java.util.Arrays;

//16. 3Sum Closest
// Example 1:
// Input: nums = [-1,2,1,-4], target = 1
// Output: 2
// Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

// Example 2:
// Input: nums = [0,0,0], target = 1
// Output: 0

public class Q16 {
    public int threeSumClosest(int[] nums, int target) {
        int len=nums.length;
        Arrays.sort(nums);
        int fixed=Integer.MAX_VALUE;
        int result=Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            //下一个元素与上一个元素相同 继续下一次循环
            if (i - 1 >= 0 && nums[i] == nums[i - 1]) continue;
            int L=i+1;
            int R=len-1;
            while(L<R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (target == sum) {
                    return target;
                } else if (sum < target) {
                    //加不加都可以
//                while(L<R&&nums[L]==nums[L+1])L++;
                    L++;
                } else if (sum > target) {
//                while(L<R&&nums[R]==nums[R-1])R--;
                    R--;
                }
                if (Math.abs(target - sum) < fixed) {
                    fixed = Math.abs(target - sum);
                    result = sum;
                }
            }
        }
        return result;
    }
}
