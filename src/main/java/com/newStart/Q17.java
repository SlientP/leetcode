package com.newStart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Letter Combinations of a Phone Number
public class Q17 {
    private HashMap<Character,String> dic=new HashMap<Character, String>(){
        {
            put('2',"a,b,c");put('3',"d,e,f");put('4',"g,h,i");
            put('5',"j,k,l");put('6',"m,n,o");put('7',"p,q,r,s");
            put('8',"t,u,v");put('9',"w,x,y,z");put('1',"");
        }
    };
    public List<String> letterCombinations(String digits) {
        int len=digits.length();
        List<String> result=new ArrayList<String>();
        for (int i = 0; i < len; i++) {
            String values=dic.get(digits.charAt(i));
            if(values.length()>0){
                String[] vals=values.split(",");
                if(result.isEmpty()){
                    for (int j = 0; j < vals.length; j++) {
                        result.add(vals[j]);
                    }
                }else{
                    List<String> temp=new ArrayList<>();
                    for (int j = 0; j < result.size(); j++) {
                        temp.add(result.get(j)+vals[j]);
                    }
                    result=temp;
                }

            }
        }
        return result;
    }
    public List<String> letterCombinationsV2(String digits) {
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
