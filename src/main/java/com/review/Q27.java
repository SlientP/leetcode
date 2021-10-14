package com.review;

//27. Remove Element
// L、R 从头开始 L记录=val的点 R记录不是val的点 
// 然后L、R 进行位置交换
public class Q27 {
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
