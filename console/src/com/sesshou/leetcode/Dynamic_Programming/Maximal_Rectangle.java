package com.sesshou.leetcode.Dynamic_Programming;

import java.util.Stack;

/**
 * @author wp41128
 * @date 2020/6/4 9:14
 * @description：最大的矩形
 */
public class Maximal_Rectangle {
    public static void main(String[] args) {
        Maximal_Rectangle test=new Maximal_Rectangle();
        char[][] a=new char[][]{ {'1','1','1','1'},{'1','1','1','1'},{'1','1','1','1'}
        };
        System.out.println(test.maximalRectangle(a));
    }
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] dp=new int[m][n];
        int maxarea=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n ; j++) {
                if(i==0) dp[i][j]=matrix[i][j]-48;
                else{
                    dp[i][j]=matrix[i][j]=='0'?0:dp[i-1][j]+1;
                }
            }
            maxarea=Math.max(maxarea,largestRectangleArea(dp[i]));
        }

        return maxarea;
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
