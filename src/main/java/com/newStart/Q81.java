package com.newStart;

//有重复元素
//[2,5,6,0,0,1,2]
//0
public class Q81 {
    public static void main(String[] args) {
        Q81 test=new Q81();
        int[] nums=new int[]{1,1};
        test.search(nums,0);
    }
    public boolean search(int[] nums, int target) {
        int len=nums.length;
        if(len==0) return false;
        int index=binarySearch(nums,0,len-1,target);
        if(index>=0) return true;
        else return false;
    }
    private int binarySearch(int[] nums,int L,int R,int target){
        while(L<R&&nums[L]==nums[L+1]) ++L;
        while(L<R&&nums[R]==nums[R-1]) --R;
        if(L==R) return nums[L]==target?L:-1;
        int mid=(L+R)/2;
        if(nums[L]<=nums[mid]){//0到mid单调增
            if(nums[R]<=target&&target<=nums[mid]){
                return binarySearch(nums,L,mid,target);
            }else{
                return binarySearch(nums,mid+1,R,target);
            }
        }else{//mid到R 单调增
            if(nums[mid]<target&&target<=nums[R]){
                return binarySearch(nums,mid+1,R,target);
            }else{
                return binarySearch(nums,L,mid,target);
            }
        }
    }
}
