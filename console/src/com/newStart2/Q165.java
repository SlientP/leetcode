package com.newStart2;

import javax.swing.plaf.IconUIResource;

public class Q165 {
    public static void main(String[] args) {
        Q165 test=new Q165();
        test.compareVersion("0.1","1.1");
    }
    public int compareVersion(String version1, String version2) {
        String[] vs1=version1.split("\\.");
        String[] vs2=version2.split("\\.");
        int m1=vs1.length;
        int m2=vs2.length;
        int m=Math.max(m1,m2);
        for (int i = 0; i < m; i++) {
            Integer v1=i>=m1?0:Integer.valueOf(vs1[i]);
            Integer v2=i>=m2?0:Integer.valueOf(vs2[i]);
            if(v1==v2) continue;
            else if(v1>v2)  return 1;
            else return -1;
        }
        return 0;
    }
}
