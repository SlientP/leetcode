package com.sesshou.leetcode;

import com.sesshou.model.ListNode;
/**
 * @author wp41128
 * @date 2020/2/28 16:12
 * @description：
 */
public class Merge_Two_Sorted_Lists {

    public static void main(String[] args){
        ListNode l11=new ListNode(1);
        ListNode l12=new ListNode(2);
        ListNode l13=new ListNode(4);
        l11.next=l12;
        l12.next=l13;
        ListNode l21=new ListNode(1);
        ListNode l22=new ListNode(3);
        ListNode l23=new ListNode(4);
        l21.next=l22;
        l22.next=l23;
        mergeTwoLists(l11,l21);
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre=new ListNode(0);
        ListNode result=pre;
        while (l1!=null||l2!=null){
            if(l1!=null&&l2!=null&&l1.val>=l2.val){
                pre.next=new ListNode(l1.val);
                l1=l1==null?null:l1.next;
                pre=pre.next;
            }else if(l2!=null&&l1!=null&&l2.val>l1.val){
                pre.next=new ListNode(l2.val);
                l2=l2==null?null:l2.next;
                pre=pre.next;
            }else if(l1==null){
                pre.next=new ListNode(l2.val);
                l2=l2==null?null:l2.next;
                pre=pre.next;
            }else if(l2==null){
                pre.next=new ListNode(l1.val);
                l1=l1==null?null:l1.next;
                pre=pre.next;
            }
         }
        return result.next;
    }


}
