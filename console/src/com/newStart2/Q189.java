package com.newStart2;

public class Q189 {
    public static void main(String[] args) {
        Q189 test=new Q189();
        int[] nums=new int[]{1,2,3,4,5,6};
        test.rotateV2(nums,4);
    }
    public void rotate(int[] nums, int k) {
        if(k==0) return;
        int len=nums.length;
        if(len%k==0){
            for (int i = 0; i < len/k; i++) {
                doit(nums,i,3,len);
            }
        }else{
            doit(nums,0,3,len);
        }

    }

    private void doit(int[] nums,int L,int k,int len){
        int R=L+k;
        while (L!=R&&R<len){
            int temp=nums[L];
            nums[L]=nums[R];
            nums[R]=temp;
            R=(R+3)%len;
        }
    }

    //遍历a圈 访问了b个元素 an=bk 要是a最小 那么 就为n、k的最小公倍数【lcm(n,k)】
    //那么需要遍历的次数为n/([lcm(n,k)]/k)=nk/[lcm(n,k)]即n，k的最大公约数
    public void rotateV2(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(k, n);
        for (int start = 0; start < count; ++start) {
            int current = start;
            int prev = nums[start];
            //使用do循环而不是while循环是因为至少要执行一次
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while (start != current);
        }
    }

    public int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }



}
