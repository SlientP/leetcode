package com.review;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.Struct.TreeNode;


//103. Binary Tree Zigzag Level Order Traversal --Q102
//层序遍历使用Zigzag交替输出
//使用双向链表就可以很轻松的实现
public class Q103 {
    public static void main(String[] args) {
        TreeNode t3=new TreeNode(3);
        TreeNode t9=new TreeNode(9);
        TreeNode t20=new TreeNode(20);
        TreeNode t15=new TreeNode(15);
        TreeNode t7=new TreeNode(7);
        t20.left=t15;t20.right=t7;
        t3.left=t9;t3.right=t20;
        Q103 test=new Q103();
        test.zigzagLevelOrder(t3);
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> temp = new LinkedList<TreeNode>();
        temp.offer(root);
        boolean direct=true;
        while (!temp.isEmpty()){
            Deque<Integer> item=new LinkedList<>();
            int count=temp.size();
            while (!temp.isEmpty()&&count>0){
                TreeNode t=temp.poll();
                if(direct){
                    item.offerLast(t.val);
                }else{
                    item.offerFirst(t.val);
                }
                count--;
                if (t.left != null) temp.offer(t.left);
                if (t.right != null) temp.offer(t.right);
               
            }
            res.add(new LinkedList<Integer>(item));
            direct=!direct;
        }
        return res;
    }
}
