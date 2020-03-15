package com.sesshou.leetcode;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeMap;

/**
 * @author wp41128
 * @date 2020/2/28 14:41
 * @description：
 */
public class Reverse_Linked_List {

    public static void main(String[] args){
        ListNode head1=new ListNode(1);
        ListNode head2=new ListNode(2);
        ListNode head3=new ListNode(3);
        ListNode head4=new ListNode(4);
        ListNode head5=new ListNode(5);
        head1.next=head2;
        head2.next=head3;
        head3.next=head4;
        head4.next=head5;
        reverseListV3(head1);
    }
    public static ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        TreeMap<Integer,ListNode> map=new TreeMap<Integer, ListNode>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        int i=0;
        while (head!=null){
            map.put(i,new ListNode(head.val));
            i++;
            head=head.next;
        }
        Iterator iterator=map.keySet().iterator();
        ListNode result=new ListNode(0);
        ListNode pre=result;
        while (iterator.hasNext()){
            Integer key=(Integer)iterator.next();
            result.next=(ListNode)map.get(key);
            result=result.next;
        }
        return pre.next;


    }

    public static ListNode reverseListV2(ListNode head) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            //保留下一个指针
            ListNode temp=curr.next;
            //断链+指链
            curr.next=prev;
            //移动指针
            prev=curr;
            //下一个元素
            curr=temp;
        }
        return prev;
    }


    public static ListNode reverseListV3(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseListV3(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }


    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
