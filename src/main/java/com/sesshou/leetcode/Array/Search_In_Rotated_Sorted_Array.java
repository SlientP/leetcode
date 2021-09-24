package com.sesshou.leetcode.Array;

/**
 * @author wp41128
 * @date 2020/3/30 14:08
 * @description：
 */
public class Search_In_Rotated_Sorted_Array {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3};
        System.out.println(search(nums, 0));
    }

    public static int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) return -1;
        if (len == 1) return nums[0]==target? 0:-1;
        int rotated_index=findRotated(nums);
        if(nums[rotated_index]==target) return rotated_index;
        if(rotated_index==0) return search(nums,0,len-1,target);
        if(nums[0]>target) return search(nums,rotated_index,len-1,target);
        else return search(nums,0,rotated_index-1,target);

    }

    public static int findRotated(int[] nums){
        int len=nums.length;
        int L=0;
        int R=len-1;
        if(nums[R]>nums[L]) return 0;
        while (L<=R){
            int mid=(L+R)/2;
            if(nums[mid]>nums[mid+1]) return mid+1;
            else{
                if (nums[mid] < nums[L])
                    R = mid - 1;
                else
                    L = mid + 1;
            }
        }
        return 0;
    }

    public static int search(int[] nums,int left, int right,int target) {
        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] == target)
                return pivot;
            else {
                if (target < nums[pivot])
                    right = pivot - 1;
                else
                    left = pivot + 1;
            }
        }
        return -1;
    }

}
