package com.newStart2;

import java.util.ArrayList;
import java.util.List;

public class Q216 {

    public static void main(String[] args) {
        Q216 test=new Q216();
        List<List<Integer>> res=test.combinationSum3(3,7);
        System.out.println(1);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res=new ArrayList<>();
        backforward(n,k,1,new ArrayList<>(),res);
        return res;
    }

    private void backforward(int n,int k,int start,List<Integer> item,List<List<Integer>> res){
        if(item.size()==k&&n==0){
            res.add(new ArrayList<>(item));
        }else if(item.size()>k||n<0) return;
        for (int i = start; i <= 9; i++) {
            if(n>=start) {
                item.add(i);
                backforward(n - i, k, i + 1, item, res);
                item.remove(item.size() - 1);
            }else break;
        }

    }
}
