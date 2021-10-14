package com.review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// 17. Letter Combinations of a Phone Number
// Example 1:
// Input: digits = "23"
// Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

// Example 2:
// Input: digits = ""
// Output: []

// Example 3:
// Input: digits = "2"
// Output: ["a","b","c"]

public class Q17 {
    private HashMap<Character,String> dic=new HashMap<Character, String>(){
        {
            put('2',"a,b,c");put('3',"d,e,f");put('4',"g,h,i");
            put('5',"j,k,l");put('6',"m,n,o");put('7',"p,q,r,s");
            put('8',"t,u,v");put('9',"w,x,y,z");put('1',"");
        }
    };
    public List<String> letterCombinations(String digits) {
        int len = digits.length();
        List<String> result = new ArrayList<String>();
        if (len == 0) return result;
        backtrack(result,0,new StringBuilder(""),digits);
        return result;
    }
    public void backtrack(List<String> result,int index,StringBuilder sb,String digits){
        if(sb.length()==digits.length()){
            result.add(sb.toString());
        }else {
            String[] maps = dic.get(digits.charAt(index)).split(",");
            for (int i = 0; i < maps.length; i++) {
                sb.append(maps[i]);
                backtrack(result, index + 1, sb, digits);
                sb.deleteCharAt(index);
            }
        }
    }
}
