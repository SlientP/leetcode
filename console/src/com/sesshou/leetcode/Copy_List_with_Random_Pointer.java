package com.sesshou.leetcode;


import java.util.HashMap;

/**
 * @author wp41128
 * @date 2020/2/26 10:08
 * @description：
 */
public class Copy_List_with_Random_Pointer {
    //递归 回溯
    HashMap<Node,Node> map=new HashMap<Node, Node>();
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        if(map.containsKey(head)){
            return map.get(head);
        }
        Node result=new Node(head.val);
        this.map.put(head, result);
        result.next=copyRandomList(head.next);
        result.random=copyRandomList(head.random);
        return result;
    }

    //迭代
    HashMap<Node,Node> mapV2=new HashMap<Node, Node>();
    public Node copyRandomListV2(Node head){
        if(head==null){
            return null;
        }
        Node oldNode=head;

        Node newNode=new Node(oldNode.val);
        this.mapV2.put(head,newNode);

        while(oldNode!=null){
            newNode.next=getCloneNode(oldNode.next);
            newNode.random=getCloneNode(oldNode.random);
            newNode=newNode.next;
            oldNode=oldNode.next;
        }
        return this.mapV2.get(head);
    }
    private Node getCloneNode(Node node){
        if(node!=null) {
            if (this.mapV2.containsKey(node)) {
                return this.mapV2.get(node);
            } else {
                this.mapV2.put(node,new Node(node.val));
                return this.mapV2.get(node);
            }
        }
        return null;
    }

    //空间迭代
    public Node copyRandomListV3(Node head){
        if(head==null){
            return null;
        }
        //复制新链表
        Node ptr = head;
        while (ptr!=null){
            Node newNode=new Node(ptr.val);
            newNode.next=ptr.next;
            ptr.next=newNode;
            ptr=ptr.next;
        }
        ptr=head;

        while (ptr!=null){
            ptr.next.random = ptr.random==null?null: ptr.random.next;
            ptr=ptr.next.next;
        }

        Node ptr_old=head;
        Node ptr_new=head.next;
        Node head_new=head.next;
        while (ptr_old!=null){
            ptr_old.next=ptr_old.next.next;
            ptr_new.next=ptr_new.next==null?null:ptr_new.next.next;
            ptr_old=ptr_old.next;
            ptr_new=ptr_new.next;
        }
        return head_new;
    }


    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
