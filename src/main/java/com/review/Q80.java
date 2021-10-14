package com.review;

//80. Remove Duplicates from Sorted Array II
public class Q80 {
    public static void main(String[] args) {
        int[] nums=new int[]{0,0,1,1,1,1,2,3,3};
        Q80 test=new Q80();
        test.removeDuplicates(nums);
    }
    //the best way
    public int removeDuplicatesV2(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int slow = 2, fast = 2;
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }
    public int removeDuplicates(int[] nums) {
        int len=nums.length;
        int slow=0;
        int count=1;
        int temp=nums[0];
        for (int i = 0; i < len; i++) {
            if(nums[i]==temp&&count<=2){
                count++;
                swap(nums,slow,i);
                slow++;
            }else if(nums[i]!=temp){
                count=1;
                temp=nums[i];
                swap(nums,slow,i);
                slow++;
            }
        }
        if(slow<len&&nums[slow]!=nums[len-1]) swap(nums, slow, len-1);
        return slow;
    }
    private void swap(int[] nums,int i,int j){
        if(i==j) return;
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
