package com.review;

//268. Missing Number -- Q448
public class Q268 { 
    // 3,0,1  901 931
    // 0,1 2,3
    // 1,0 1,2 3,2
    //因为nums 包含0 如果0和nums.length都指向同一个位置
    public int missingNumber(int[] nums) {
        if(nums[0]==1) return 0;
        int len=nums.length;
        for (int i = 0; i < len; i++) {
            int index=nums[i]%len;
            nums[index]+=len;
        }
        for (int i = 0; i < len; i++) {
            if(nums[i]<len) return i;
        }
        return len;
    }
    public int missingNumberV2(int[] nums) {
        int missing=nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing^=i^nums[i];
        }
        return missing;
    }
}
