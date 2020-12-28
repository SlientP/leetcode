package com.newStart;

//search Insert Position
public class Q35 {
    public static void main(String[] args) {
        Q35 test=new Q35();
        int[] nums=new int[]{1,3,5,6};
        test.searchInsertV2(nums,5);
    }
    //O(n)
    public int searchInsert(int[] nums, int target) {
        int len=nums.length;
        if(len==0) return 0;
        int L=0;
        while (L<len&&nums[L]<target)L++;
        return L;
    }
    //O(lgN)
    //找到第一个大于等于target的位置
    public int searchInsertV2(int[] nums, int target) {
        int len=nums.length;
        if(len==0) return 0;
        int L=0;
        int R=len-1;
        int result=len;
        while (L<R){
            int mid=(L+R)/2;
            if (target <= nums[mid]) {
                result = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return result;
    }
}
