package com.review;

import java.util.ArrayList;
import java.util.List;

//89. Gray Code
public class Q89 {
    public List<Integer> grayCode(int n) {
        List<Integer> result=new ArrayList<>();
        result.add(0);
        int temp=0;
        for (int i = 0; i <= n; i++) {
            //由于是add是在末尾增加 因此j不能从0开始
            for (int j = result.size() -1 ; j >= 0; j--) {
                result.add(result.get(j)+temp);
            }
            temp=temp<<1;
        }
        return result;
    }
}
