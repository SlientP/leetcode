package com.sesshou;

//1 3 5 6 9 11 15 20
//
//1---1
//2---2
//3---2+1+2=5
//4---5+5+2+2=14
//5---14+14+5+5+2+2=42
//6---42+42+14+14+(2*5)*2=84+28+20=132
//7---132+132+42+42+(2*14)*2+5*5=264+84+25+56=429
//8---429+429+132+132+(2*42)*2+(5*14)*2=858+264+168+140=1157
public class MakeBrinaryTree {

    public static void main(String[] args) {
        MakeBrinaryTree test=new MakeBrinaryTree();
        System.out.println(test.makeTree(8));
    }

    public int makeTree(int n){
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i]+=dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}
