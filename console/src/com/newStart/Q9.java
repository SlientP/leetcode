package com.newStart;


//Palindrome Number(Easy)
//Cases:正负数 0
//      大于最大整数 小于最小负数

//如果采用倒置的方式 可能会超过边界值
//如果一个数是回文 k为x的长度
//逐步划分 x/10==x之余的 或者 x==x之余
//这种情况无序考虑超过边界的问题
public class Q9 {
    public static void main(String[] args) {
        Q9 test=new Q9();
        System.out.println(test.isPalindrome(10));
    }
    public boolean isPalindrome(int x) {
        int temp=0;
        if(x==0) return true;
        while(x>temp){
            temp=temp*10+x%10;
            if(temp==0) return false;
            if(x==temp||x/10==temp) return true;
            x=x/10;
        }
        return false;
    }
    public boolean V2isPalindrome(int x) {
        //负数肯定不行；
        //个位为0的肯定不行
        if(x<0||(x%10==0&&x!=0)) return false;
        int res=0;
        while (x>res){
            res=res*10+x%10;
            x=x/10;
        }
        return x==res/10||x==res;
    }
}
