package com.review;


import java.util.ArrayList;
import java.util.List;

//93. Restore IP Addresses
public class Q93 {
    public static void main(String[] args) {
        
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> result=new ArrayList<>();
        backforward(result, 0, s.length(), new ArrayList<>(), s);
        return result;
    }
    private void backforward(List<String> res,int start,int len,List<Integer> temp,String s){
        if(start==len&&temp.size()==4){
            StringBuilder sb=new StringBuilder();
            sb.append(temp.get(0));
            sb.append(".");
            sb.append(temp.get(1));
            sb.append(".");
            sb.append(temp.get(2));
            sb.append(".");
            sb.append(temp.get(3));
            res.add(sb.toString());
        }
        if(s.charAt(start)=='0'){
            temp.add(0);
            backforward(res, start+1, len, temp, s);
            temp.remove(temp.size()-1);
        }else{
            for (int i = 0; i < 3 &&  start+1+i<=len; i++) {
                Integer integer=Integer.valueOf(s.substring(start,start+i+1));
                if(integer>0&&integer<256){
                    temp.add(integer);
                    backforward(res, start+1, len, temp, s);
                    temp.remove(temp.size()-1);
                }
            }   
        }
    }
}
