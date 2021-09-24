package com.newStart;

//Reverse Integer(Easy)
//考虑正数 负数 正数最大 负数最小
public class Q7 {
    public static void main(String[] args) {
        Q7 test=new Q7();
        System.out.println(test.reverse(2147483647));
    }
    public int reverse(int x) {
        int result=0;
        while (x!=0){
            if(result>Integer.MAX_VALUE/10||result<Integer.MIN_VALUE/10) return 0;
            result=result*10+x%10;

            x=x/10;
        }
        return result;
    }

    public int reverseV2(int x) {
        long n = 0;
        while(x != 0) {
            n = n*10 + x%10;
            x = x/10;
        }
        return (int)n==n? (int)n:0;
    }
}
