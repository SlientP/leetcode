package com.newStart;

//链表是从各位开始的
//1.首先声明头指针用于连接节点
//2.在考虑进位时需考虑上一步的进位
//3.最后2个尾结点相加可能导致进位 必须在头部补1
//4.链表指向下一个节点要判断下非空
public class Q2 {
    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(9);
        l2.next=new ListNode(9);
        Q2 test=new Q2();
        ListNode reslut=test.addTwoNumbers(l1,l2);
        System.out.println("success");
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(0);//1
        ListNode result=head;
        int carry=0;//2
        while(l1!=null||l2!=null){
            int x=l1==null?0:l1.val;
            int y=l2==null?0:l2.val;
            head.next=new ListNode((x+y+carry)%10);//3
            head=head.next;
            l1=l1==null?null:l1.next;//4
            l2=l2==null?null:l2.next;//4
            if(x+y+carry>=10) carry=1;//3
            else carry=0;
        }
        if(carry>0) head.next=new ListNode(1);//3
        return result.next;
    }

    public ListNode V2addTwoNumbers(ListNode l1,ListNode l2){
        ListNode head=new ListNode(0);
        ListNode res=head;
        if(l1==null) return l2;
        if(l2==null) return l1;
        int carry=0;
        while (l1!=null||l2!=null){
            int x=l1==null?0:l1.val;
            int y=l2==null?0:l2.val;
            int sum=x+y+carry;
            head.next = new ListNode(sum % 10);
            head=head.next;
            if(sum>=10) carry=1;
            else carry=0;
            l1=l1==null?null:l1.next;
            l2=l2==null?null:l2.next;
        }
        if(carry>0) head.next=new ListNode(1);
        return res.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
