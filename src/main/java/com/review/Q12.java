package com.review;

//12. Integer to Roman
public class Q12 {
    private final String[] pers=new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I",};
    private final int[] vals=new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
    public String intToRoman(int num) {
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < pers.length; i++) {
            while (num>= vals[i]){
                num-=vals[i];
                sb.append(pers[i]);
            }
        }
        return  sb.toString();
    }
}
