package com.review;

import java.util.*;

//116. Populating Next Right Pointers in Each Node
//目前需要使用O(n) 有方法使用O（1）
public class Q116 {
    public static void main(String[] args) {
        Node n1=new Node(1);Node n2=new Node(2);
        Node n3=new Node(3);Node n4=new Node(4);
        Node n5=new Node(5);Node n6=new Node(6);
        Node n7=new Node(7);
        n1.left=n2;n1.right=n3;
        n2.left=n4;n2.right=n5;n3.left=n6;n3.right=n7;
        Q116 test=new Q116();
        test.connect(n1);
    }
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        
        // 初始化队列同时将第一层节点加入队列中，即根节点
        Queue<Node> queue = new LinkedList<Node>(); 
        queue.add(root);
        
        // 外层的 while 循环迭代的是层数
        while (!queue.isEmpty()) {
            // 记录当前队列大小
            int size = queue.size();
            // 遍历这一层的所有节点
            for (int i = 0; i < size; i++) {
                // 从队首取出元素
                Node node = queue.poll();
                // 连接
                if (i < size - 1) {
                    node.next = queue.peek();
                }
                // 拓展下一层节点
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        // 返回根节点
        return root;
    }
    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
    
        public Node() {}
        
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
