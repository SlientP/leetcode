package com.sesshou.leetcode.Microsoft;

/**
 * @author wp41128
 * @date 2020/6/18 14:37
 * @description：
 */
public class Design_Tic_Tac_Toe {
    public static void main(String[] args) {
        System.out.println(true&&false|false);
    }
    int[] rows, cols, dig;
    int n;
    public Design_Tic_Tac_Toe(int n) {
        rows = new int[n];
        cols = new int[n];
        dig = new int[2];
        this.n = n;
    }
    public int move(int row, int col, int player) {
        //横|竖|左上-右下|右下-左上
        return ((player == 1 && rows[row]++ == n-1 | cols[col]++ == n-1 | (row == col && dig[0]++ == n-1) | (row + col == n-1 && dig[1]++ == n-1))
                || (player == 2 && rows[row]-- == 1-n | cols[col]-- == 1-n | (row == col && dig[0]-- == 1-n) | (row + col == n-1 && dig[1]-- == 1-n))) ? player : 0;
    }



}
