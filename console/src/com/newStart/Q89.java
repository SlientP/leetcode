package com.newStart;

import java.util.ArrayList;
import java.util.List;

public class Q89 {
    public static void main(String[] args) {
        Q89 test=new Q89();
        List<Integer> result=test.grayCode(2);
        System.out.println(1<<1);
        System.out.println(2<<1);
        System.out.println(3<<1);
        System.out.println(4<<1);
    }
    public List<Integer> grayCode(int n) {
        List<Integer> result=new ArrayList<>();
        result.add(0);
        int temp=1;
        for (int i = 0; i < n; i++) {
            for (int j = result.size()- 1 ; j >= 0; j--) {
                result.add(result.get(j)+temp);
            }
            temp=temp<<1;
        }
        return result;
    }

}
