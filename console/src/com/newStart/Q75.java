package com.newStart;

public class Q75 {
    public static void main(String[] args) {
        Q75 test=new Q75();
        //2,0,2,1,1,0
        int[] nums=new int[]{0,1,0};
        test.sortColors(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
    // 0 0 2 1 1 2
    //
    public void sortColors(int[] nums) {
        int len=nums.length;
        if(len<=1) return;
        int L=0,R=len-1;
        int insert_2=len-1;
        int insert_0=0;
        while (L<=R){
            if(nums[L]==2){
                swap(nums,L,insert_2);
                insert_2--;
            }else if(nums[L]==0){
                insert_0++;
            }
            L++;
            if(nums[R]==0){
                swap(nums,R,insert_0);
                insert_0++;
            }else if(nums[R]==2){
                insert_2--;
            }
            R--;

        }
    }
    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
