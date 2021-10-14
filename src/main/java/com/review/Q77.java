package com.review;

import java.util.ArrayList;
import java.util.List;

//77. Combinations
public class Q77 {
    public static void main(String[] args) {
        Q77 test=new Q77();
        test.combine(4, 2);
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        dfs(res,temp,k,n,1);
        return res;
    }
    private void dfs(List<List<Integer>> res,List<Integer> temp,int k,int n,int start){
        if(temp.size()==k){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i <= n; i++) {
            temp.add(i);
            dfs(res, temp, k, n, i+1);
            temp.remove(temp.size()-1);
        }
    }
}
