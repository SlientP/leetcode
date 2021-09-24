package com.newStart;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Q113 {
    public static void main(String[] args) {
        TreeNode t1=new TreeNode(5); TreeNode t2=new TreeNode(4); TreeNode t3=new TreeNode(8);
        TreeNode t4=new TreeNode(11); TreeNode t5=new TreeNode(13); TreeNode t6=new TreeNode(4);
        TreeNode t7=new TreeNode(7); TreeNode t8=new TreeNode(2); TreeNode t9=new TreeNode(5);
        TreeNode t10=new TreeNode(1);
        t1.left=t2;t1.right=t3;t2.left=t4;t4.left=t7;t4.right=t8;t3.left=t5;t3.right=t6;t6.left=t9;t6.right=t10;
        Q113 test=new Q113();
        test.pathSum(t1,22);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        List<Integer> item=new ArrayList<>();
        backforward(res,item,root,sum);
        return res;
    }

    private void backforward(List<List<Integer>> res,List<Integer> item,TreeNode root,int sum){
        if(root.val>sum) return;
        else {
            if (root.val == sum && root.left == null && root.right == null) {
                item.add(root.val);
                res.add(new ArrayList<>(item));
                item.remove(item.size() - 1);
                return;
            }
            if (root.left != null) {
                item.add(root.val);
                backforward(res, item, root.left, sum - root.val);
                item.remove(item.size() - 1);
            }
            if(root.right!=null){
                item.add(root.val);
                backforward(res, item, root.right, sum - root.val);
                item.remove(item.size() - 1);
            }


        }

    }


    List<List<Integer>> ret = new LinkedList<List<Integer>>();
    Deque<Integer> path = new LinkedList<Integer>();

    public List<List<Integer>> pathSumV2(TreeNode root, int sum) {
        dfs(root, sum);
        return ret;
    }

    public void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        path.offerLast(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            ret.add(new LinkedList<Integer>(path));
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
        path.pollLast();
    }

    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}
