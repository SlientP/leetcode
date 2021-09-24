package com.newStart2;

/**
 * Created by Administrator on 2021/4/13 0013.
 */
public class Q238 {
    public int[] productExceptSelf(int[] nums) {
        int len=nums.length;
        int[] res=new int[len];
        //从左边开始遍历
        res[0]=1;
        for (int i = 1; i <len ; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        //从右边开始遍历
        int R=1;
        for (int i = len-1; i>0 ; i--) {
            res[i]=res[i]*R;
            R=nums[i]*R;
        }
        return res;
    }
}
