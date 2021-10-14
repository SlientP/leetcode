package com.review;

import java.util.*;
import com.Struct.*;

//113. Path Sum II
public class Q113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        return res;
    }

    private void dfs(List<List<Integer>> res,List<Integer> temp,TreeNode node,int sum){
        if(node.left==null&&node.right==null&&node.val==sum){
            temp.add(node.val);
            res.add(new ArrayList<>(temp));
            temp.remove(temp.size()-1);
            return;
        }
        temp.add(node.val);
        if (node.left != null) {
            dfs(res, temp, node.left, sum - node.val);
        }
        if(node.right!=null){
            dfs(res, temp, node.right, sum - node.val);
        }
        temp.remove(temp.size() - 1);
    }
}
