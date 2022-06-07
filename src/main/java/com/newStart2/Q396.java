package com.newStart2;

public class Q396 {
    //F(0)=0*nums[0]+1*nums[1]+...+(n-2)*nums[n-2]+(n−1)*nums[n−1]
    //F(1)=1*nums[0]+2*nums[1]+...+(n-1)*nums[n-2]+0*nums[n-1]
    //    =F(0)+nums[0]+nums[1]+...+nums[n-2]+nums[n-1]-n*nums[n-1]
    //    =1*num[0]+2*nums[1]+...+(n-1)*nums[n-2]+n*nums[n-1]-n*nums[n-1]
    //    =F(0)+numsSum-n*nums[n-1]
    //F(2)=2*nums[0]+3*nums[1]+...+0*nums[n-2]+1*nums[n-1]
    //    =F(1)+nums[0]+nums[1]+nums[n-2]+nums[n-1]-(n-1)*nums[n-2]
    //    =F(1)+numsSum-n*nums[n-2]
    //F(3)=F(2)+numsSum-n*nums[n-3]
    //F(k)=F(k-1)+numsSum-n*nums[n-k]
    public int maxRotateFunctionV2(int[] nums){
        int n=nums.length;
        int numsSum=0;
        int res=0;
        for (int i = 0; i < n; i++) {
            numsSum+=nums[i];
            res+=i*nums[i];
        }
        int temp=res;
        for (int i = 1; i < n; i++) {
            temp+=numsSum-n*nums[n-i];
            res=Math.max(res, temp);
        }
        return res;
    }
    public int maxRotateFunction(int[] nums) {
        int len=nums.length;
        if(len<=1) return 0;
        int result=Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int temp=0;
            int j=1;
            int k=i+1;
            while(k!=i){
                if(k==len) {
                    k=0;
                    continue;
                }
                temp+=j*nums[k];
                k++;j++;
            }
            result=Math.max(result,temp);
        }
        return result; 
    }
}
