package com.sesshou.leetcode.Array;

/**
 * Created by Administrator on 2020/4/13 0013.
 */
public class Wiggle_Sort {
    public static void main(String[] args) {
        Wiggle_Sort test=new Wiggle_Sort();
        int[] nums=new int[]{1,5,3,2,6,4};
        test.wiggleSort(nums);
        System.out.println("123");
    }
    public void wiggleSort2(int[] nums) {
        boolean less = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (less) {
                if (nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            } else {
                if (nums[i] < nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            }
            less = !less;
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void wiggleSort(int[] nums) {
        int len=nums.length;
        if(len==1||len==0) return;
        if(len==2){
            if(nums[0]>nums[1]){
                int temp=nums[0];
                nums[0]=nums[1];
                nums[1]=temp;
            }
            return;
        }
        int L=0;
        while (L<len&&(L+2)<len){
            if(L%2==0) {
                //L>L+1 L>L+2
                if (nums[L] >= nums[L + 1] && nums[L] >= nums[L + 2]) {
                    int temp=nums[L];
                    nums[L]=nums[L+1];
                    nums[L+1]=temp;
                }
                // L+2>L L+2>L+1
                else if (nums[L] <= nums[L + 2] && nums[L + 2] >= nums[L + 1]) {
                    int temp=nums[L+2];
                    nums[L+2]=nums[L+1];
                    nums[L+1]=temp;
                }
            }else{
                //L>L+1 L>L+2
                if (nums[L] <= nums[L + 1] && nums[L] <= nums[L + 2]) {
                    int temp=nums[L];
                    nums[L]=nums[L+1];
                    nums[L+1]=temp;
                }
                // L+2>L L+2>L+1
                else if (nums[L + 2] <= nums[L] && nums[L + 2] <= nums[L + 1]) {
                    int temp=nums[L+2];
                    nums[L+2]=nums[L+1];
                    nums[L+1]=temp;
                }
            }
            L++;
        }

    }
}
