package com.newStart;

//Remove Element
public class Q27 {
    public static void main(String[] args) {
        Q27 test=new Q27();
        int[] nums=new int[]{2};
        System.out.println(test.removeElement(nums,3));
    }
    public int removeElement(int[] nums, int val) {
        int len=nums.length;
        if(len==0) return 0;
        int L=0;
        int R=0;
        while (R<len){
            while (L<len&&nums[L]!=val) L++;
            R=L;
            while (R<len&&nums[R]==val) R++;
            if(R<len){
                nums[L]=nums[R];
                nums[R]=val;
                L++;
                R++;
            }
        }
        return L;
    }
}
