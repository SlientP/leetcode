package com.sesshou.leetcode.Microsoft;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wp41128
 * @date 2020/6/18 15:10
 * @description：序列化反序列化一个树
 */
public class Serialize_and_Deserialize_N_ary_Tree {
    public static void main(String[] args) {
        Serialize_and_Deserialize_N_ary_Tree test=new Serialize_and_Deserialize_N_ary_Tree();
        Node a=new Node(11);
        Node b=new Node(22);
        Node c=new Node(33);
        Node d=new Node(44);
        Node e=new Node(55);
        Node f=new Node(66);
        a.children.add(c);
        a.children.add(b);
        a.children.add(d);
        c.children.add(e);
        c.children.add(f);
        System.out.println(test.serialize(a));
    }
    public String serialize(Node root) {
        if(root==null) return "";
        StringBuilder result=new StringBuilder();
        result.append(root.val);
        if(root.children.isEmpty()){
            return result.toString();
        } else{
            result.append("[");
            for (Node c : root.children) {
                // 重新利用serialize()函数的含义，把每一个child Node都序列化即可
                result.append(serialize(c));
                result.append(",");
            }
            result.deleteCharAt(result.length()-1);
            result.append("]");
        }
        return result.toString();
    }


    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data==null||data.length()==0) return null;
        String[] child=data.substring(data.lastIndexOf('['),data.indexOf(']')).split(",");
        List<Node> childNodes=new ArrayList<Node>();
        for (int i = 0; i < child.length; i++) {
            childNodes.add(new Node(Integer.valueOf(child[i])));
        }
        return new Node();
    }


    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
            children=new ArrayList<Node>();
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
