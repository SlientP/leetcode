package com.newStart;

public class Q75 {
    public static void main(String[] args) {
        Q75 test=new Q75();
        //2,0,2,1,1,0
        //0,1,0
        //1,2,0
        //2,1,2
        int[] nums=new int[]{2,0,2,1,1,0};
        test.sortColorsV2(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
    // 0 0 2 1 1 2
    //
    public void sortColors(int[] nums) {
        int len=nums.length;
        if(len<=1) return;
        int insert_0=0;
        int insert_1=0;
        for (int i = 0; i < len; i++) {
            if(nums[i]==0){
                swap(nums,i,insert_0);
                //insert_0代表是1的位置 如果insert_0和insert_1不在同一个位置上则代表交换的位置是1
                //需要再和insert_1交换一次位置 保证1在前面
                if(insert_0<insert_1) swap(nums,i,insert_1);
                insert_0++;insert_1++;
            }else  if(nums[i]==1){
                swap(nums,i,insert_1);
                insert_1++;
            }
        }
    }
    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public void sortColorsV2(int[] nums){
        int len=nums.length;
        if(len<=1) return;
        int insert_0=0;
        int insert_2=len-1;
        for (int i = 0; i < len; i++) {
            if(nums[i]==0){
                swap(nums,i,insert_0);
                insert_0++;
                i--;
            }else if(nums[i]==2){
                swap(nums,i,insert_2);
                insert_2--;
                i--;
            }
        }
    }
}
