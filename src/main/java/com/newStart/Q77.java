package com.newStart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q77 {
    public static void main(String[] args) {
        Q77 test=new Q77();
        List<List<Integer>> res=test.combine(4,2);
        System.out.println(1);
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();

        backtrack(k, n, output, res, 1);
        return res;

    }

    public void backtrack(int k,int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (output.size() == k) {
            res.add(new ArrayList<Integer>(output));
            return;
        }
        for (int i = first; i <= n ; i++) {
            // 动态维护数组
            output.add(i);
            // 继续递归填下一个数
            backtrack(k,n, output, res, i+1);
            // 撤销操作
            output.remove(new Integer(i));
        }
    }

}
