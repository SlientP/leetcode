package com.review;

public class Q733 {
    public static void main(String[] args) {
        int[][] image=new int[][]{{1,1,1},{1,1,0},{1,0,1}};
        Q733 test=new Q733();
        test.floodFill(image, 1, 1, 2);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m=image.length;
        int n=image[0].length;
        if(image[sr][sc]!=newColor){
            fill(image, m, n, sr, sc,image[sr][sc], newColor);
        }
        return image;
    }

    private void fill(int[][] image,int m,int n, int sr, int sc,int oldColor, int newColor){
        if(sr>=0&&sr<m&&sc>=0&sc<n){
            image[sr][sc]=newColor; 
            if(sr+1<m&&image[sr+1][sc]==oldColor){
                fill(image,m,n,sr+1, sc,oldColor, newColor);
            }
            if(sr-1>=0&&image[sr-1][sc]==oldColor){
                fill(image,m,n, sr-1, sc,oldColor, newColor);
            }
            if(sc+1<n&&image[sr][sc+1]==oldColor){
                fill(image,m,n,sr, sc+1,oldColor, newColor);
            }
            if(sc-1>=0&&image[sr][sc-1]==oldColor){
                fill(image,m,n, sr, sc-1,oldColor, newColor);
            }
           
            
        }
        return;
    }
    
}
