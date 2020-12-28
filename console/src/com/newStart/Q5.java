package com.newStart;

//Longest Palindromic Substring(middle)
//一、动态规划
//dp[i,j]表示i-j是回文串
//dp[i,i]肯定是一个会问字符串 dp[i][i+1] i=i+1
//dp[i,j]=dp[i+1,j-1]&&i==j
// eg:babad
//  b a b a d
//b 1 0 m y x
//a   1 y x z
//b     1 z n
//a       1 0
//d         1
//二、中心扩散
//以i 或者[i,i+1]扩展到两边元素不相等
//返回的最大len即为当前扩散的最大范围
public class Q5 {
    public static void main(String[] args) {
        Q5 test=new Q5();
        System.out.println(test.longestPalindromeV2("bb"));
    }
    public String longestPalindrome(String s) {
        int len=s.length();
        if(len<2) return s;
        char[] chars=s.toCharArray();
        String result=String.valueOf(chars[0]);//初始化为字符串首字母
        boolean[][] dp=new boolean[len][len];
        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j  ; i++) {
                if(i==j) dp[i][j]=true;
                else if(i+1==j) dp[i][j]=chars[i]==chars[j];
                else dp[i][j]=dp[i+1][j-1]&&chars[i]==chars[j];
                if(i!=j&&dp[i][j]&&j-i+1>result.length()){
                    result=s.substring(i,j+1);
                }
            }
        }
        return result;
    }

    public String longestPalindromeV2(String s){
        int len=s.length();
        if(len<2) return s;
        String res="";
        for (int i = 0; i < len; i++) {
            String s1=expandString(i,i,s);
            String s2=expandString(i,i+1,s);
            String temps=s1.length()>s2.length()?s1:s2;
            res=temps.length()>res.length()?temps:res;
        }
        return res;
    }

    private String expandString(int i,int j,String s){
        int L=i-1;
        int R=j+1;
        if(j<s.length()&&s.charAt(i)==s.charAt(j)){
            while (L>=0&&R<s.length()&&s.charAt(L)==s.charAt(R)){
                L--;R++;
            }
            return s.substring(L+1,R);
        }else return String.valueOf(s.charAt(i));

    }
}
