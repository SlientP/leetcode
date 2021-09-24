package com.sesshou;


public class Dai {

    public static void main(String[] args) {
        int[]  nums=new int[]{-1, 2, 1, 3, 6, 5, 7};
        Dai test=new Dai();
        int[] result=test.find(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public int[] find(int[] array){
        int len=array.length;
        int L=0;int R=len-1;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int mid=Integer.MIN_VALUE;
        while (L<=R){
            if(min>array[L]) min=array[L++];
            else if(R==len-1 && array[R]>min) {
                max = array[R];
                R--;
            }else if(array[R]>max){
                if(max!=Integer.MIN_VALUE){
                    mid=max;
                }
                max=array[R];
                R--;
            }else{
                L++;R--;
            }


        }
        return new int[]{min,max,mid};
    }
}
