package com.review;

import java.util.*;
import com.Struct.*;

//445. Add Two Numbers II
//Use Stack 
public class Q445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1=new Stack<>();
        Stack<Integer> s2=new Stack<>();
        while(l1!=null){
            s1.add(l1.val);
            l1=l1.next;
        }
        while(l2!=null){
            s2.add(l2.val);
            l2=l2.next;
        }
        int carry=0;
        Stack<Integer> s3=new Stack<>();
       
        while(!s1.isEmpty()||!s2.isEmpty()||carry!=0){
            int a=s1.isEmpty()?0:s1.pop();
            int b=s2.isEmpty()?0:s2.pop();
            int temp=a+b+carry;
            s3.push(temp%10);
            carry=temp/10;
        }
        ListNode result=new ListNode(0);
        ListNode pre=result;
        while(!s3.isEmpty()){
            pre.next=new ListNode(s3.pop());
            pre=pre.next;
        }
        return result.next;
    }
}
