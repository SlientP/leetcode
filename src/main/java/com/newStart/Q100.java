package com.newStart;

//Same Tree(Simple)
//1.比较根节点不为空且节点的值相等
//2.比较左节点和右节点 如果都不为空 继续比较值和下属的节点
//3.直到叶子节点为空 如果2个节点都为空则返回true
public class Q100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p!=null&&q!=null&&p.val==q.val){
            return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
        }else if(p==null&&q==null){
            return true;
        }
        return false;
    }
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }
}

