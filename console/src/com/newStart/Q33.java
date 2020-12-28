package com.newStart;

//Search in Rotated Sorted Array
//mid只有与0比较才能知道哪边是单调增
//如果target在单调增的范围内则搜索单调递增的范围
//否则搜索另一边
public class Q33 {
    public static void main(String[] args) {
        Q33 test=new Q33();
        int[] nums=new int[]{5,1,3};
        System.out.println(test.search(nums,5));
    }
    public int search(int[] nums, int target) {
        int len=nums.length;
        return binarySearch(nums,0,len-1,target);
    }
    private int binarySearch(int[] nums,int L,int R,int target){
        if(L==R) return nums[L]==target?L:-1;
        int mid=(L+R)/2;
        if(nums[0]<=nums[mid]){//0到mid单调增
            if(nums[0]<=target&&target<=nums[mid]){
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
