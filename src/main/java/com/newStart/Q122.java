package com.newStart;

public class Q122 {
    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int totalprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            while (i<prices.length-1&&prices[i+1]>prices[i]) i++;
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > 0) {
                totalprofit += prices[i] - minprice;
                minprice = Integer.MAX_VALUE;
            }
        }
        return totalprofit;
    }
}
