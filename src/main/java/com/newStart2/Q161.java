package com.newStart2;

public class Q161 {
    public boolean isOneEditDistance(String s, String t) {
        int m=s.length();
        int n=t.length();

        //保证s比较长
        if(n>m){
            String temp=s;
            s=t;
            t=s;
            int k=m;
            m=n;
            n=k;
        }
        if(m==n+1){
            int count=0;
            for (int i = 0; i < n; i++) {
                while (s.charAt(i)!=t.charAt(i+count)) count++;
                if(count>=2) return false;
            }
            return true;
        }else if(m==n){
            int count=0;
            for (int i = 0; i < m; i++) {
                if(i+count<m&&s.charAt(i)!=t.charAt(i)) count++;
                if(count>=2) return false;
            }
            return count==1;
        }else return false;
    }
}
