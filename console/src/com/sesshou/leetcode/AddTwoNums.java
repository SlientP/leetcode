package com.sesshou.leetcode;

/**
 * @author wp41128
 * @date 2020/2/26 9:24
 * @description：
 */
public class AddTwoNums {
    //1.初始化结果链表
    //2.定义链表、进位
    //2.1 L1或L2 不为空继续
    //2.2 结果相加 %10取当前位值 /10取进位值
    //2.3 L1不为空就指向下一个 L2 不为空就指向下一个
    //2.4 最后一位的节点可能会有进位
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result=new ListNode(0);
        ListNode cur=result;
        int temp=0;
        while(l1!=null||l2!=null){
            int x=l1==null?0:l1.val;
            int y=l2==null?0:l2.val;
            int sum=temp+x+y;
            temp=sum/10;
            cur.next=new ListNode(sum%10);
            cur=cur.next;
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
        }
        if(temp>0){
            cur.next=new ListNode(1);
        }
        return result.next;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
