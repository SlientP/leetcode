package com.newStart;

public class Q74 {
    public static void main(String[] args) {
        int[][] martix=new int[][]{{1,3}};
        Q74 test=new Q74();
        System.out.println(test.searchMatrix(martix,3));
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int m= matrix.length;
        if(m==0) return false;
        int n=matrix[0].length;
        int Li=0;
        int Ri=m-1;
        int Midi;
        if(target>=matrix[Li][0]&&target<=matrix[Ri][n-1]){
            while (Li<=Ri){
                Midi=(Li+Ri)/2;
                if(Li==Ri){
                    int L=0,R=n-1;
                    while (L<=R){
                        Midi=(L+R)/2;
                        if(matrix[Li][Midi]==target) return true;
                        else if(matrix[Li][Midi]>target){
                            R=Midi-1;
                        }else{
                            L=Midi+1;
                        }
                    }
                    return false;
                }
                else if(matrix[Midi][0]>target){
                    Ri=Midi-1;
                }else if(matrix[Midi][n-1]<target){
                    Li=Midi+1;
                }else{
                    Ri=Li=Midi;
                }
            }
        }
        return false;
    }
}
