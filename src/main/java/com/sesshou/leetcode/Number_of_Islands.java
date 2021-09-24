package com.sesshou.leetcode;

/**
 * @author wp41128
 * @date 2020/3/20 10:12
 * @description：0 1 陆地
 */
public class Number_of_Islands {
    public static void main(String[] args) {
        Number_of_Islands test=new Number_of_Islands();
        char[][] grid=new char[][]{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        System.out.println(test.numIslands(grid));
    }
    public int numIslands(char[][] grid) {
        int num=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length ; j++) {
                if(grid[i][j]=='0') continue;
                else{
                    num++;
                    setlandtowater(grid,i,j);
                }
            }
        }
        return num;
    }

    private void setlandtowater(char[][] grid,int i,int j){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length) return;
        if(grid[i][j]=='0') return;
        else{
            grid[i][j]='0';
            setlandtowater(grid,i-1,j);
            setlandtowater(grid,i+1,j);
            setlandtowater(grid,i,j-1);
            setlandtowater(grid,i,j+1);
        }
    }
}
