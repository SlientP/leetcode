package com.Struct;

import java.util.Arrays;

//测试Array的相关操作
public class TestArray {
    public static void main(String[] args) {
        TestArray test=new TestArray();
        int[] a=new int[]{1,3,5,6,7,8,9,2,3,4};
        int[] copy_a=Arrays.copyOf(a, 4);//1,3,5,6
        System.out.println("copy_a:");
        test.print(copy_a);
        int[] copyrange_a=Arrays.copyOfRange(a, 1, 4);//3,5,6
        System.out.println("copyrange_a:");
        test.print(copyrange_a);
    }

    private void print(int[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            System.out.print(',');
        }
        System.out.println("");
    }
}
