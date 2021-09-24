package com.sesshou.leetcode.Dynamic_Programming;

import java.util.Stack;

/**
 * @author wp41128
 * @date 2020/6/17 16:19
 * @description：最好的时机售卖股票
 */
public class Best_Time_to_Buy_and_Sell_Stock {
    public static void main(String[] args) {
        Best_Time_to_Buy_and_Sell_Stock test=new Best_Time_to_Buy_and_Sell_Stock();
        int[] prices=new int[]{1,2};
        System.out.println(test.maxProfit(prices));
    }
    public int maxProfit(int[] prices) {
        int ans=0;
        int len=prices.length;
        if(len==0) return 0;
        Stack<Integer> stack=new Stack<Integer>();
        for (int i = 0; i < len; i++) {
            while(!stack.empty()&&stack.peek()>prices[i]){
                ans=Math.max(stack.peek()-stack.firstElement(),ans);
                stack.pop();
            }
            stack.push(prices[i]);
        }
        return Math.max(stack.peek()-stack.firstElement(),ans);
    }
}
