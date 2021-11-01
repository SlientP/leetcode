package com.review;

import com.Struct.*;
import java.util.*;

public class Q145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        dfs(root, result);
        return result;
    }

    private void dfs(TreeNode node,List<Integer> list){
        if(node==null) return;
        dfs(node.left,list);
        dfs(node.right,list);
        list.add(node.val);
    } 
}
