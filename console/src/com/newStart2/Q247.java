package com.newStart2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Q247 {
    public static void main(String[] args) {
        Q247 test=new Q247();
        List<String> res=test.findStrobogrammatic(4);
        System.out.println(1);
    }
    private List<String> one=new ArrayList<String>(){{add("1");add("0");add("8");}};
    private List<String> secondV2=new ArrayList<String>(){{add("11");add("88");add("69");add("96");}};
    private List<String> second=new ArrayList<String>(){{add("11");add("88");add("69");add("96");add("00");}};
    public List<String> findStrobogrammatic(int n) {
        return dfs(n);
    }
    private List<String> dfs(int n){
        if(n==1)  return one;
        if(n==2)  return secondV2;
        List<String> res=new ArrayList<>();
        if((n-1)%2==0){
            List<String> temp=dfs(n-1);
            for (int i = 0; i < temp.size(); i++) {
                for (int j = 0; j < one.size(); j++) {
                    StringBuilder s=new StringBuilder(temp.get(i));
                    res.add(s.insert(n/2,one.get(j)).toString());
                }
            }
        }else{
            List<String> temp=dfs(n-2);
            for (int i = 0; i < temp.size(); i++) {
                for (int j = 0; j < second.size(); j++) {
                    StringBuilder s=new StringBuilder(temp.get(i));
                    res.add(s.insert((n-2)/2,second.get(j)).toString());
                }
            }
        }
        return res;
    }
}
