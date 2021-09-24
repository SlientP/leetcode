package com.newStart;

//Container With Most Water(middle)
//双指针
public class Q11 {
    public static void main(String[] args) {
        Q11 test=new Q11();
        int[] heights=new int[]{1,3,2,5,25,24,5};
        System.out.println(test.V2maxArea(heights));
    }
    public int maxArea(int[] height) {
        int result=0;
        int len= height.length;
        int L=0;
        int R=len-1;
        int temp=0;
        while (L<R){
            result=Math.max(Math.min(height[L],height[R])*(R-L),result);
            if(height[L]<=height[R]){
                temp=L+1;
                while (height[L]>height[temp]) temp++;
                L=temp;
            }else{
                temp=R-1;
                while (height[R]>height[temp]) temp--;
                R=temp;
            }

        }
        return result;
    }

    public int V2maxArea(int[] height) {
        int len=height.length;
        int L=0;
        int R=len-1;
        int res=0;
        while (L<R){
            res=Math.max(res,Math.min(height[L],height[R])*(R-L));
            if(height[L]<height[R]){
                int temp=L;
                while (temp<R&&height[temp]>height[temp+1]) temp++;
                L=temp;
            }else{
                int temp=R;
                while (L<temp&&height[temp]>height[temp-1]) temp--;
                R=temp;
            }
        }
        return res;
    }
}
