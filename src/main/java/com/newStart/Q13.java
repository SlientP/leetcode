package com.newStart;

import java.util.HashMap;

//Roman to Integer
//    I             1
//    V             5
//    X             10
//    L             50
//    C             100
//    D             500
//    M             1000
public class Q13 {
    public static void main(String[] args) {
        Q13 test=new Q13();
        System.out.println(test.romanToInt("MCMXCIV"));
    }
    private final HashMap<Character,Integer> maps=new HashMap<Character, Integer>(){
        {
            put('I',1);put('V',5);put('X',10);put('L',50);
            put('C',100);put('D',500);put('M',1000);
        }
    };
    public int romanToInt(String s) {
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
