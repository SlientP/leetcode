package com.review;

//136. Single Number
//只出现过一次  其他的数字出现过2次
//使用异或的方式 自身和自身异或是0；0和任何树异或是他自己本身
public class Q136 {
    public int singleNumber(int[] nums) {
        int res=0;
        for (int i = 0; i < nums.length; i++) {
            res^=nums[i];
        }
        return res;
    }
}
