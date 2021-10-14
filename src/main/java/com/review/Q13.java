package com.review;

import java.util.HashMap;

//13. Roman to Integer
public class Q13 {
    
    public int romanToInt(String s) {
        HashMap<Character,Integer> maps=new HashMap<Character, Integer>(){
            {
                put('I',1);put('V',5);put('X',10);put('L',50);
                put('C',100);put('D',500);put('M',1000);
            }
        };
        int result=0;
        int[] vals=new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            vals[i]=maps.get(s.charAt(i));
        }
        for (int i = 0; i < s.length()-1; i++) {
            if(vals[i]>=vals[i+1]){
                result+=vals[i];
            }else{
                result-=vals[i];
            }
        }
        result+=vals[s.length()-1];
        return result;
    }
}
