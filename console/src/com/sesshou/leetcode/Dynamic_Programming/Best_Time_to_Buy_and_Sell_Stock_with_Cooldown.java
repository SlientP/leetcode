package com.sesshou.leetcode.Dynamic_Programming;

/**
 * @author wp41128
 * @date 2020/6/17 19:28
 * @description：
 */
public class Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {
    public static void main(String[] args) {
        Best_Time_to_Buy_and_Sell_Stock_with_Cooldown test=new Best_Time_to_Buy_and_Sell_Stock_with_Cooldown();
        int[] prices=new int[]{1,2,3,0,2};
        System.out.println(test.maxProfit(prices));
    }
    public int maxProfit(int[] prices) {
        int len=prices.length;
        if(len==0)return 0;
        if(len <= 1) return 0; // 特殊情况处理
        if(len==2 && prices[0]>=prices[1]) return 0; // 特殊情况处理
        else if(len == 2 && prices[0]<prices[1]) return prices[1]-prices[0]; // 特殊情况处理
        int[][] dp=new int[len][2];

        dp[0][0] = 0; // 第一天，不持有股票
        dp[0][1] = -prices[0]; // 第一天，持有股票
        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]); // 第二天，不持有股票
        dp[1][1] = Math.max(dp[0][0]-prices[1], dp[0][1]); // 第二天，持有股票


        //0代不表持有股票 1代表持有股票
        for (int i = 2; i < len ; i++) {
            //持有股票的最大利润
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);

            dp[i][1]=Math.max(dp[i-2][0]-prices[i],dp[i-1][1]);

        }
        return dp[len-1][0];
    }
}
