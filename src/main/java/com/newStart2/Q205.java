package com.newStart2;

import java.util.HashMap;
import java.util.Map;

//"foo"
//"bar"
public class Q205 {
    public boolean isIsomorphic(String s, String t) {
        int m=s.length();
        int n=t.length();
        if(m!=n) return false;
        HashMap<Character,Character> map=new HashMap<>();
        char[] ss=s.toCharArray();
        char[] tt=t.toCharArray();
        int si=0;
        int ti=0;
        for (int i = 0; i < m; i++) {
            char p=ss[i];
            char q=tt[i];
            if(map.isEmpty()||!map.containsValue(q)){
                ti++;
            }
            if(map.isEmpty()||!map.containsKey(p)){
                si++;
            }
            if(si==ti) {
                if (map.isEmpty() || !map.containsKey(p)) {
                    map.put(p, q);
                    ss[i] = q;
                } else {
                    ss[i] = map.get(p);
                }
            }else return false;

        }
        return t.equals(String.valueOf(ss));
    }

    //维护2张hash表
    public boolean isIsomorphicV2(String s, String t) {
        Map<Character, Character> s2t = new HashMap<Character, Character>();
        Map<Character, Character> t2s = new HashMap<Character, Character>();
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            char x = s.charAt(i), y = t.charAt(i);
            if ((s2t.containsKey(x) && s2t.get(x) != y) || (t2s.containsKey(y) && t2s.get(y) != x)) {
                return false;
            }
            s2t.put(x, y);
            t2s.put(y, x);
        }
        return true;
    }

}
