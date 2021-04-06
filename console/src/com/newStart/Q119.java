package com.newStart;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q119 {
    public static void main(String[] args) {
        Q119 test=new Q119();
        test.getRow(3);
    }
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i = 0; i < rowIndex; i++) {
            for (int j = i; j >= 1; j--) {
                list.set(j, list.get(j - 1) + list.get(j));
            }
            list.add(1);
        }
        return list;
    }
}
