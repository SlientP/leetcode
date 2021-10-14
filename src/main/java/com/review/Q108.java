package com.review;

import com.Struct.*;

//108. Convert Sorted Array to Binary Search Tree
public class Q108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return ArrayToBBT(nums,0,nums.length-1);
    }
    private TreeNode ArrayToBBT(int[] nums,int left ,int right){
        if(left>=0&&left< nums.length&&right>=0&&right<nums.length) {
            if (left > right) return null;
            else if (left == right) return new TreeNode(nums[left]);
            int mid = (left + right) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = ArrayToBBT(nums, left, mid - 1);
            root.right = ArrayToBBT(nums, mid + 1, right);
            return root;
        }
        return null;
    }
}
