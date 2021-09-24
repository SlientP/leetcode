package com.newStart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q133 {
    public static void main(String[] args) {
        Node n1=new Node(1);Node n2=new Node(2);
        Node n3=new Node(3);Node n4=new Node(4);
        n1.neighbors.add(n2);n1.neighbors.add(n3);
        n2.neighbors.add(n1);n2.neighbors.add(n3);
        n3.neighbors.add(n2);n3.neighbors.add(n4);
        n4.neighbors.add(n3);n4.neighbors.add(n1);
        Q133 test=new Q133();
        Node n11=test.cloneGraph(n1);
        System.out.println(1);
    }

    private HashMap<Integer,Node> map=new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        Node res;
        if(map.isEmpty()||!map.keySet().contains(node.val)) {
            res=new Node(node.val);
        }else{
            res=map.get(node.val);
            return res;
        }
        if(node.neighbors!=null){
            map.put(node.val, res);
            for (Node item:node.neighbors) {
                res.neighbors.add(cloneGraph(item));
            }
        }
        return res;
    }
    // Definition for a Node.
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
