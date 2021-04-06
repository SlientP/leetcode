package com.newStart;

import java.util.Stack;

public class Q121 {
    public int maxProfit(int[] prices) {
        int minprice=Integer.MAX_VALUE;
        int maxbenfit=0;//如果数组单调递减..则无法购买
        for (int i = 0; i < prices.length; i++) {
            if(prices[i]<minprice){
                minprice=prices[i];
            }else{
                maxbenfit=Math.max(maxbenfit,prices[i]-minprice);
            }
        }
        return maxbenfit;
    }
}
