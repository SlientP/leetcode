package com.newStart2;

public class Q153 {
    public static void main(String[] args) {
        Q153 test=new Q153();
        int[] nums=new int[]{11,13,15,17};
        System.out.println(test.findMin(nums));
    }
    public int findMin(int[] nums) {
        int len=nums.length;
        if(len==0) return 0;
        int L=0;
        int R=len-1;
        while (L<R){
            int mid=(L+R)/2;
            if(nums[mid]>nums[0]&&nums[mid]>nums[len-1]){
                L=mid+1;
            }else{
                R=mid;
            }
        }
        return Math.min(nums[L],nums[R]);
    }
}
