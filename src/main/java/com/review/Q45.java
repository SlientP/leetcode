package com.review;

//45. Jump Game II ---Q55
//最少跳几次
public class Q45 {
    public static void main(String[] args){
        Q45 test=new Q45();
        int[] nums=new int[]{1,1,2,1,1};
        System.out.print(test.jump(nums));
    }
    public int jump(int[] nums) {
        int len=nums.length;
        int max=nums[0];
        int end=nums[0];
        if(len==1) return 0;
        int step=1;
        int i=0;
        while(i<len){
            if(i<=end){ 
                max=Math.max(max, i+nums[i]);
                //只有在计算跳的最远距离的时候才i++
                //else的情况 不用i++
                i++;
            }else {
                step++;
                end=max;
            }
            
            if(end>=len-1) return step;
        }
        return step;
    }
}
