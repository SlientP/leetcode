package com.review;

//378. Kth Smallest Element in a Sorted Matrix
//只能保证行和列是递增的 不能保证整个数组都是递增的
public class Q378 {
    public static void main(String[] args) {
        //[[1,5,9],[10,11,13],[12,13,15]]
        //int[][] matrix=new int[][]{{1,5,9},{10,11,13},{12,13,15}};
        //[-5,-4][-5,-4]
        int[][] matrix=new int[][]{{-5,-4},{-5,-4}};
        Q378 test=new Q378();
        test.kthSmallest(matrix, 2);
    }
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        int m=matrix[0].length;
        int left =matrix[0][0];
        int right=matrix[n-1][m-1];
        while(left<right){
            int mid=(left+right)>>1;//向下取整
            int mid2=(left+right)/2;//向上取整
            if(check(matrix, mid, k)){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }   

    private boolean check(int[][] matrix,int target,int k){
        int n=matrix.length;
        int m=matrix[0].length;
        int L=n-1;
        int R=0;
        int num=0;
        while(L>=0&&R<m){
            if(matrix[L][R]<=target){
                num+=L+1;
                R++;
            }else{
                L--;
            }
        }
        return num>=k;
    }
}
