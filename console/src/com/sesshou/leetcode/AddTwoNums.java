package com.sesshou.leetcode;

/**
 * @author wp41128
 * @date 2020/2/26 9:24
 * @description：
 */
public class AddTwoNums {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result=new ListNode(0);
        ListNode cur=result;
        int temp=0;
        while(l1.next!=null||l2.next!=null){
            int x=l1==null?0:l1.val;
            int y=l2==null?0:l2.val;
            int sum=temp+x+y;
            temp=sum/10;
            cur.next=new ListNode(sum%10);
            cur=cur.next;
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
        }
        return result.next;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
