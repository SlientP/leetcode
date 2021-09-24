package com.newStart2;


import java.util.ArrayList;

import java.util.List;

public class Q518 {


    public int change(int amount, int[] coins) {
        int len=coins.length;
        if(len==0) return 0;
        int[] dp=new int[amount+1];
        dp[0]=1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <amount ; j++) {
                dp[j]=dp[j-coins[i]]+dp[j];
            }
        }
        return dp[amount];
    }
    public int changeV2(int amount, int[] coins) {
        int len=coins.length;
        if(len==0) return 0;
        List<List<Integer>> result=new ArrayList<>();
        bcakforward(result,new ArrayList<Integer>(),amount,coins,0);
        return result.size();
    }
    //out of time
    public void bcakforward(List<List<Integer>> list,List<Integer> temp,int target,int[] coins,int i){
        if(target==0){
            list.add(new ArrayList<>(temp));
        }
        if(target<0) return;
        for (;i<coins.length;i++){
            temp.add(coins[i]);
            bcakforward(list,temp,target-coins[i],coins,i);
            temp.remove(temp.size()-1);
        }
    }
}
