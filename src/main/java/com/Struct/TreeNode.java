package com.Struct;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

//对于树的遍历 做一个总结
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    //树的遍历前序，中序，后序都是根据树的根节点访问顺序
    //前序遍历:根节点-->左节点-->右节点
    //中序遍历:左节点-->根节点-->右节点
    //后序遍历:左节点-->右节点-->根节点
    //dfs版3种历
    public void preorder(TreeNode root,List<Integer> res){
        if(root==null) return;
        res.add(root.val);
        if(root.left!=null) preorder(root.left, res);
        if(root.right!=null) preorder(root.right, res);
    }
    public void medium (TreeNode root,List<Integer> res){
        if(root==null) return;
        if(root.left!=null) medium(root.left, res);
        res.add(root.val);
        if(root.right!=null) medium(root.right, res);
    }
    public void postorder(TreeNode root,List<Integer> res){
        if(root==null) return;
        if(root.left!=null) postorder(root.left, res);
        if(root.right!=null) postorder(root.right, res);
        res.add(root.val);
    }
    //层序遍历 也叫广度优先遍历
    //并且层序输出
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> temp=new ArrayDeque<>();
        temp.offer(root);
        while (!temp.isEmpty()){
            List<Integer> item=new ArrayList<>();
            int count=temp.size();
            while (!temp.isEmpty()&&count>0){
                TreeNode t=temp.poll();
                item.add(t.val);
                count--;
                if(t.left!=null) temp.offer(t.left);
                if(t.right!=null) temp.offer(t.right);
            }
            res.add(item);
        }
        return res;
    }
}
