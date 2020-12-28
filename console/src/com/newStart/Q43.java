package com.newStart;

import java.util.ArrayList;
import java.util.List;
//因为num1和num2的长度都可能达到110 明显超出最大正整数的范围


public class Q43 {

    public static void main(String[] args) {
        Q43 test=new Q43();
        System.out.println(test.multiply("123","456"));
        System.out.println(test.multiplyV2("123","456"));
    }
    //解法1 把数组相乘拆分成 个位数乘字符串 字符串相加
    public String multiply(String num1, String num2) {
        int len1=num1.length();
        int len2=num2.length();
        String result="";
        List<String> sum=new ArrayList<String>();
        if(len1==0||len2==0) return result;
        else if(num1.equals("0")||num2.equals("0")) return "0";
        for (int i = len2-1; i >=0 ; i--) {
            int temp=num2.charAt(i)-'0';
            StringBuilder s=new StringBuilder(mul(temp,num1));
            int j=len2-1-i;
            while (j>0){
                s.append("0");
                j--;
            }
            result=add(s.toString(),result);
        }

        return result;
    }

    public String mul(Integer i,String num){
        int carry=0;
        StringBuilder result=new StringBuilder();
        for (int j = num.length()-1; j >= 0 ; j--) {
            int mul_res=i*(num.charAt(j)-'0')+carry;
            carry=mul_res/10;
            result.insert(0,mul_res%10);
        }
        if(carry>0){
            result.insert(0,carry);
        }
        return result.toString();
    }

    public String add(String num1,String num2){
        if(num1.length()==0||num1.equals("0")){
            return num2;
        }else if(num2.length()==0||num2.equals("0")){
            return num1;
        }else{
            int fix=Math.abs(num1.length()-num2.length());
            if(num1.length()<num2.length()){
                String temp=num1;
                num1=num2;
                num2=temp;
            }
            //insure num1>num2
            StringBuilder result=new StringBuilder();
            int carry=0;
            for (int i = num1.length() -1; i >=0 ; i--) {
                int sum_res= num1.charAt(i)+
                        (i-fix>=0?num2.charAt(i-fix)-'0': 0) -'0'+carry;
                carry=sum_res/10;
                result.insert(0,sum_res%10);
            }
            if(carry>0){
                result.insert(0,carry);
            }
            return result.toString();
        }
    }
    //解法2 用数组存储结果
    public String multiplyV2(String num1,String num2){
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int len1=num1.length();
        int len2=num2.length();
        int[] arr=new int[len1+len2];
        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                arr[i+j+1] +=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
             }
        }
        for (int i = len1+len2-1; i >=1 ; i--) {
            arr[i-1]+=arr[i]/10;
            arr[i]=arr[i]%10;
        }
        int start=arr[0]==0?1:0;//相乘是否进位了
        StringBuilder sb=new StringBuilder();
        while (start<len1+len2){
            sb.append(arr[start]);
            start++;
        }
        return sb.toString();
    }
}
