package com.newStart;

import javax.swing.plaf.IconUIResource;

public class Q134 {
    public static void main(String[] args) {
        Q134 test=new Q134();
        int[] gas=new int[]{1,2,3,4,5};
        int[] cost=new int[]{3,4,5,1,2};
        test.canCompleteCircuitV2(gas,cost);
    }
    //假设x最远能到达y，那么x y中间的任意一个点都到达不了y+1
    //假设中间点z x 到达z时，如果噶闹为0，那么也就刚好能到达y，如果到达z的时候多了油，那么去掉之前的z最远能到达的也就是Y
    //如此可以剔除x到y的点
    public int canCompleteCircuitV2(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        while (i < n) {
            int sumOfGas = 0, sumOfCost = 0;
            int cnt = 0;
            //能到达的最远点
            while (cnt < n) {
                int j = (i + cnt) % n;
                sumOfGas += gas[j];
                sumOfCost += cost[j];
                if (sumOfCost > sumOfGas) {
                    break;
                }
                cnt++;
            }
            //如果回到原点返回i
            //没有的话从第i+1开始 cnt只是代表位移
            if (cnt == n) {
                return i;
            } else {
                i = i + cnt + 1;
            }
        }
        return -1;
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int g_len=gas.length;
        if(g_len==0) return 1;
        int[] dif=new int[g_len];
        int total_cost=0;
        int total_gas=0;
        for (int i = 0; i < g_len; i++) {
            total_cost+=cost[i];
            total_gas+=gas[i];
            dif[i]=gas[i]-cost[i];
        }
        if(total_cost>total_gas) return -1;
        for (int i = 0; i < g_len; i++) {
            if(dif[i]<0) continue;
            if(canArrive(i,gas,cost,dif)) return i;
        }
        return -1;
    }
    private boolean canArrive(int i,int[] gas,int[] cost,int[] dif){
        int rest=dif[i];
        int end=i;
        i++;
        while (i<gas.length||i<end){
            if(i==end) break;
            if(rest+gas[i] >= cost[i]){
                rest=rest+gas[i]-cost[i];
            }else return false;
            i++;
            if(i==gas.length) i=0;
        }
        return true;
    }
}
