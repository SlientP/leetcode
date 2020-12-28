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
                    
                }

            }
        }
        return result;
    }
}
