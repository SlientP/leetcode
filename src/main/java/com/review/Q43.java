package com.review;


//43. Multiply Strings
public class Q43 {
    public String multiply(String num1, String num2) {
        int len1=num1.length();
        int len2=num2.length();
        String result="";
        if(len1==0||len2==0) return result;
        else if(num1.equals("0")||num2.equals("0")) return "0";
        for (int i = len2-1; i >=0 ; i--) {
            int temp=num2.charAt(i)-'0';
            StringBuilder s=new StringBuilder(mul(temp,num1));
            //补齐后面的0
            int j=len2-1-i;
            while (j>0){
                s.append("0");
                j--;
            }
            result=add(s.toString(),result);
        }

        return result;
    }

    private String mul(int a,String b){
        StringBuilder sb=new StringBuilder();
        int len=b.length();
        int carry=0;
        for (int i = len; i >= 0; i--) {
            int mul_res=(b.charAt(i)-'0')*a+carry;
            carry=mul_res/10;
            sb.insert(0,mul_res%10);
        }
        if(carry>0) sb.insert(0, carry);
        return sb.toString();
    }

    private String add(String a,String b){
        StringBuilder sb=new StringBuilder();
        int len1=a.length();
        int len2=b.length();
        int carry=0;
        if(len2>len1){
            String temp=a;
            a=b;
            b=temp;
        }
        int fix=Math.abs(len2-len1);
        for (int i = a.length()-1; i >= 0; i--) {
            int temp=a.charAt(i)-'0'+
            i-fix>=0?b.charAt(i-fix)-'0':0 +
            carry;
            carry=temp/10;
            sb.insert(0,temp%10);
        }
        if(carry>0) sb.insert(0, "1");
        return sb.toString();
    }
}
