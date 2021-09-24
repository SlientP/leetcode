package com.sesshou.leetcode.Array;

import java.util.Stack;

/**
 * @author wp41128
 * @date 2020/6/9 7:39
 * @description：最大的矩形
 */
public class Largest_Rectangle_in_Histogram {

    public static void main(String[] args) {
        Largest_Rectangle_in_Histogram test=new Largest_Rectangle_in_Histogram();
        int[] a=new int[]{2,1,5,6,2,3};
        System.out.println(test.largestRectangleArea(a));
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<Integer> ();
        stack.push(-1);
        int maxarea = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i])
                maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
            stack.push(i);
        }
        while (stack.peek() != -1)
            maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() -1));
        return maxarea;
    }

}
