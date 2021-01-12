package com.newStart;

import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.List;

public class Q93 {
    public static void main(String[] args) {
        Q93 test=new Q93();
        List<String> res=test.restoreIpAddresses("19216811");
        System.out.println("1");
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> res=new ArrayList<>();
        if(s.length()<4||s.length()>12) return res;
        backforward(res,s,0,s.length(),new ArrayList<Integer>());
        return res;
    }

    private void backforward(List<String> res,String s,int start,int end,List<Integer> item){
        if(start==end&&item.size()==4){
            StringBuilder sb=new StringBuilder();
            sb.append(item.get(0));sb.append("."+item.get(1));sb.append("."+item.get(2));sb.append("."+item.get(3));
            res.add(sb.toString());
        }
        if(item.size()<4&&start<end) {
            if(s.charAt(start)=='0'){
                item.add(new Integer("0"));
                backforward(res, s, start+1, end, item);
                item.remove(item.size()-1);
            }else {
                for (int i = 0; i < 3 && start+i+1<=end; i++) {
                    Integer x = new Integer(s.substring(start, start+i+1));
                    if (x > 0 && x <= 255) {
                        item.add(x);
                        backforward(res, s, start+i+1, end, item);
                        item.remove(item.size()-1);
                    }
                }
            }
        }
    }
}
