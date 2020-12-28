package com.newStart.todo;

import java.util.LinkedHashMap;

public class Q38 {
    public static void main(String[] args) {
        Q38 test=new Q38();
        test.countAndSay(3);
    }
    //1 11 21 1211 111221 312211 13112221 1113213211 31121211131221 13211211123113112211
    LinkedHashMap<String,String> map=new LinkedHashMap<String, String>(){
        {
            put("111","31");put("222","32");put("333","33");
            put("11","21");put("22","22");put("11","21");
            put("1","11");put("2","12");put("3","13");
        }
    };
    public String countAndSay(int n) {
        String s=new String("1");
        while (n>1){
            for (String key: map.keySet()) {
                s.contains(key);
                s=s.replaceAll(key,map.get(key));
            }
            n--;
        }
        return s;
    }
}
