package com.newStart;

//Remove Nth Node From End of List
//双指针标记 开始和结尾
//1.头尾指向
//在已N为代表确定尾结点的位置
//尾结点可能已经为null 2中情况 远大于链表长度 则不需要做任何修改
//刚好等于链表长度 移除头结点
//尾结点还没为null  头尾同时移动 当尾结点的next为null停止
//如果n是有效的 那么则不需要考虑超出的情况 不需要记录链表长度 不需要判断链表长度和N之间的关系
public class Q19 {
    public static void main(String[] args) {
        Q19 test=new Q19();
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(4);
        ListNode l5=new ListNode(5);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        ListNode result=test.removeNthFromEnd(l1,2);
        System.out.println("123");
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode result=head;
        ListNode tail=head;
        int i=n;
        int len=0;
        while (i>0){
            i--;
            if(tail!=null){
                tail=tail.next;
                len++;
            }else tail=null;
        }
        if(tail!=null){
            while (tail.next!=null){
                head=head.next;
                tail=tail.next;
            }
            head.next=head.next.next;
        }else{
            if(n>len) return result;
            else{
                return result.next;
            }
        }
        return result;
    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
