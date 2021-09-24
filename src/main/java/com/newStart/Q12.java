package com.newStart;

import java.util.logging.SimpleFormatter;

//Integer to Roman (middle)
public class Q12 {
    public static void main(String[] args) {
        Q12 test=new Q12();
        System.out.println(test.intToRoman(0));
        System.out.println(test.intToRomanV2(1994));
    }
    public String intToRoman(int num) {
        String res="";
        int count=0;
        while (num>=1000){
            res+="M";
            num-=1000;
        }
        while (num>=100){
            res+="C";
            count++;
            num-=100;
        }
        if(count==4){
            res=res.replace("CCCC","CD");
        }
        else if(count>4&&count<9){
            res=res.replace("CCCCC","D");
        }else if(count==9){
            res=res.replace("CCCCCCCCC","CM");
        }
        count=0;
        while (num>=10){
            res+="X";
            count++;
            num-=10;
        }
        if(count==4){
            res=res.replace("XXXX","XL");
        }
        else if(count>4&&count<9){
            res=res.replace("XXXXX","L");
        }else if(count==9){
            res=res.replace("XXXXXXXXX","XC");
        }
        count=0;
        while (num>0){
            res+="I";
            count++;
            num-=1;
        }
        if(count==4){
            res=res.replace("IIII","IV");
        }
        else if(count>4&&count<9){
            res=res.replace("IIIII","V");
        }else if(count==9){
            res=res.replace("IIIIIIIII","IX");
        }
        return res;
    }

    private final String[] pers=new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I",};
    private final int[] vals=new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};

    public String intToRomanV2(int num){
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
