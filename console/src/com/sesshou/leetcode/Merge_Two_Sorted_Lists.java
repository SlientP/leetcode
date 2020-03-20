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
        ListNode node= mymergeTwoLists(l11,l21);
        System.out.println("1111");
    }
    public static ListNode mymergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre=new ListNode(0);
        ListNode result=pre;
        while (l1!=null||l2!=null){
            if(l1!=null&&l2!=null&&l1.val<=l2.val){
                pre.next=new ListNode(l1.val);
                l1=l1==null?null:l1.next;
                pre=pre.next;
            }else if(l2!=null&&l1!=null&&l2.val<l1.val){
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
    //迭代
    public ListNode mergeTwoListsV2(ListNode l1, ListNode l2) {
        // maintain an unchanging reference to node ahead of the return node.
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // exactly one of l1 and l2 can be non-null at this point, so connect
        // the non-null list to the end of the merged list.
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }
    //递归
    public ListNode mergeTwoListsV3(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoListsV3(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoListsV3(l1, l2.next);
            return l2;
        }

    }
}
