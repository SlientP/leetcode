package com.newStart;

import java.util.List;

public class Q92 {
    public static void main(String[] args) {
        Q92 test=new Q92();
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(4);
        ListNode l5=new ListNode(5);
        l1.next=l2;l2.next=l3;l3.next=l4;l4.next=l5;
        test.reverseBetween(l1,2,4);
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        //change(head,m,n);
        //return head;

        this.left = head;
        this.stop = false;
        this.recurseAndReverse(head, m, n);
        return head;
    }

    private void change(ListNode head, int m, int n){
        if(m>=n) return;
        ListNode p1=head;
        int L=m,R=n;
        while (L>1){
            p1=p1.next;
            L--;
        }
        ListNode LL=p1;
        p1=head;
        while (R>1){
            p1=p1.next;
            R--;
        }
        ListNode RR=p1;
        int temp=LL.val;
        LL.val=RR.val;
        RR.val=temp;
        change(head,m+1,n-1);
    }


    // Object level variables since we need the changes
    // to persist across recursive calls and Java is pass by value.
    private boolean stop;
    private ListNode left;

    public void recurseAndReverse(ListNode right, int m, int n) {

        // base case. Don't proceed any further
        if (n == 1) {
            return;
        }

        // Keep moving the right pointer one step forward until (n == 1)
        right = right.next;

        // Keep moving left pointer to the right until we reach the proper node
        // from where the reversal is to start.
        if (m > 1) {
            this.left = this.left.next;
        }

        // Recurse with m and n reduced.
        this.recurseAndReverse(right, m - 1, n - 1);

        // In case both the pointers cross each other or become equal, we
        // stop i.e. don't swap data any further. We are done reversing at this
        // point.
        if (this.left == right || right.next == this.left) {
            this.stop = true;
        }

        // Until the boolean stop is false, swap data between the two pointers
        if (!this.stop) {
            int t = this.left.val;
            this.left.val = right.val;
            right.val = t;

            // Move left one step to the right.
            // The right pointer moves one step back via backtracking.
            this.left = this.left.next;
        }
    }



    public ListNode reverseBetweenV2(ListNode head, int m, int n){
        if(head==null||head.next==null) return head;
        ListNode curr=head,pre=null;
        while (m>1){
            pre=curr;
            curr=curr.next;
            m--;n--;
        }
        ListNode con=pre;
        ListNode tail=curr;
        ListNode thrid=null;
        while (n>1){
            thrid=curr.next;
            curr.next=pre;
            pre=curr;
            curr=thrid;
            n--;
        }
        //con为null 即从头翻转；那么头就是新的pre
        if(con!=null){
            con.next=pre;
        }else{
            head = pre;
        }
        tail.next=curr;
        return head;
    }

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
