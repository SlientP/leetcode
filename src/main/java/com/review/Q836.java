package com.review;

public class Q836 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x11=rec1[0],y11=rec1[1],x12=rec1[2],y12=rec1[3];
        int x21=rec2[0],y21=rec2[1],x22=rec2[2],y22=rec2[3];
        if(x22<=x11||//左
        x12<=x21||//右
        y12<=y21||//上
        y11>=y22)//下
         return false;
        if(x11==x21&&y11==y21&&x12==x22&&y12==y22) return true;
        return true;
    }
}
