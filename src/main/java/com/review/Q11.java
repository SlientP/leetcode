package com.review;

//11. Container With Most Water
public class Q11 {
    public static void main(String[] args) {
        Q11 test=new Q11();
        int[] height=new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(test.maxArea(height));
    }

    public int maxArea(int[] height) {
        int max=0;
        int len=height.length;
        if(len==0) return max;
        int L=0;int R=len-1;
        while(L<R){
            max=Math.max(Math.min(height[L],height[R])*(R-L),max);
            if(height[L]<=height[R]){
                int l=L;
                //missing the =
                while(l<len&&height[l]<=height[L]) l++;
                L=l;
            }else{
                int r=R;
                while(r>0&&height[r]<=height[R]) r--;
                R=r;
            }
        }
        return max;
    }
}
