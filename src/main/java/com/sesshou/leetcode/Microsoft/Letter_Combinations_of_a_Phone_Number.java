package com.sesshou.leetcode.Microsoft;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wp41128
 * @date 2020/7/7 15:19
 * @description：电话号码的字母组合
 */
public class Letter_Combinations_of_a_Phone_Number {
    private final String[][] letters=new String[][]{
            {"","","",""},
            {"","","",""},
            {"a","b","c",""},
            {"d","e","f",""},
            {"g","h","i",""},
            {"j","k","l",""},
            {"m","n","o",""},
            {"p","q","r","s"},
            {"t","u","v",""},
            {"w","x","y","z"}};

    public static void main(String[] args) {
        Letter_Combinations_of_a_Phone_Number test=new Letter_Combinations_of_a_Phone_Number();
        List<String> result=test.letterCombinations("23");
        for (String item:result) {
            System.out.println(item);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> result=new ArrayList<String>();
        for (int i = 0; i < digits.length() ; i++) {
            result=addLetters(digits.charAt(i)-48,result);
        }
        return result;
    }

    private List<String> addLetters(int i,List<String> data){
        List<String> result=new ArrayList<String>();

        for (int j = 0; j < 4; j++) {
            if(letters[i][j].length()>0){
                if(data==null||data.isEmpty()){
                    result.add(letters[i][j]);
                }else {
                    for (String item : data) {
                        result.add(item + letters[i][j]);
                    }
                }
            }
        }
        return result;
    }
}
