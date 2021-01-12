package com.newStart;

public class Q80 {
    //0,0,1,1,1,1,2,3,3

    public static void main(String[] args) {
        int[]  nums=new int[]{1,1,1};
        Q80 test=new Q80();
        test.removeDuplicates(nums);
        System.out.println(1);
    }
    public int removeDuplicates(int[] nums) {
        int len=nums.length;
        if(len<=2) return len;
        int L=1;
        int result=len-1;
        int count=1;
        int temp=nums[0];
        while (L<len){
            if(temp==nums[L]){
                count++;
            }else{
                count=1;
                temp=nums[L];
            }
            if(count>2){
                nums[L]=Integer.MIN_VALUE;
                result--;
            }
            L++;
        }
        L=0;
        int R=0;
        while (L<=result){
            while (L<len&&nums[L]!=Integer.MIN_VALUE) L++;
            if(R<=L) R=L;
            while (R<len&&nums[R]==Integer.MIN_VALUE) R++;
            if(R<len) {
                int a = nums[L];
                nums[L] = nums[R];
                nums[R] = a;
                L++;R++;
            }
        }
        return result+1;
    }


    public int removeDuplicatesV2(int[] nums){
        int insert=1,count=1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]==nums[i-1]){
                count++;
            }else{
                count=1;
            }
            if(count<=2){
                nums[insert++]=nums[i];
            }
        }
        return insert;
    }
}
