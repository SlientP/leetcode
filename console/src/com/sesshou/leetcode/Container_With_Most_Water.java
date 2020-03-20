package com.sesshou.leetcode;

import sun.plugin2.message.GetAppletMessage;

/**
 * @author wp41128
 * @date 2020/3/20 9:37
 * @description：包含最多的水
 */
public class Container_With_Most_Water {
    public static void main(String[] args) {
        Container_With_Most_Water test=new Container_With_Most_Water();
        int[] a=new int[]{76,155,15,188,180,154,84,34,187,142,22,5,27,183,111,128,50,58,2,112,179,2,100,111,115,76,134,120,118,103,31,146,58,198,134,38,104,170,25,92,112,199,49,140,135,160,20,185,171,23,98,150,177,198,61,92,26,147,164,144,51,196,42,109,194,177,100,99,99,125,143,12,76,192,152,11,152,124,197,123,147,95,73,124,45,86,168,24,34,133,120,85,81,163,146,75,92,198,126,191};
        System.out.println(test.maxArea(a));
    }
     public int maxArea(int[] height) {
         int value=0;
         int l=0;
         int r=height.length-1;
         while (l<r){
             value=Math.max(Math.max(height[l],height[r])*(r-l),value);
             if(height[l]>height[r]){
                 r--;
             }else{
                 l++;
             }
         }
         return value;
     }


}
