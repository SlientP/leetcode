package com.newStart2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q249 {
    public static void main(String[] args) {
        String[] strings=new String[]{"abc","am"};
        Q249 test=new Q249();
        test.groupStrings(strings);
    }
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res=new ArrayList<>();
        HashMap<String,List<String>> map=new HashMap<>();
        for (String s:strings) {
            StringBuilder key = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                key.append((char)(((s.charAt(i)-s.charAt(0)+26)%26)+'a'));
            }
            List<String> temp=map.getOrDefault(key.toString(),new ArrayList<String>());
            temp.add(s);
            map.put(key.toString(),temp);
        }
        for (String key:map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }

    private int cal(char a,char b){
        if(b>a) return 'z'-b+a-'a'+1;
        else return 'z'-a+b-'a'+1;
    }
}
