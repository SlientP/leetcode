package com.newStart2;


import java.util.Random;

//经典之作
public class Q215 {

    public static void main(String[] args) {
        Q215 test=new Q215();
        int[] nums=new int[]{3,2,1,5,6,4};
        System.out.println(test.findKthLargestV2(nums,2));
    }
    //快速排序 start
    Random random=new Random();
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums,0,nums.length-1,nums.length-k);
    }

    public int quickSelect(int[] a, int l, int r, int index) {
        int q = getIndex(a, l, r);
        if (q == index) {
            return a[q];
        } else {
            return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
        }
    }

    private int getIndex(int[] nums,int l,int r){
        int index=random.nextInt(r-l+1)+l;
        swap(nums,index,r);
        return partition(nums,l,r);
    }

    public int partition(int[] a, int l, int r) {
        int x=a[r];int i=l;
        for (int j = l; j < r; j++) {
            if(a[j]<=x){
                swap(a,j,i);
                i++;
            }
        }
        swap(a,i,r);
        return i;
    }
    //快速排序 end

    //堆排序 start
    public int findKthLargestV2(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
            swap(nums, 0, i);
            --heapSize;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    public void buildMaxHeap(int[] a, int heapSize) {
        for (int i = heapSize / 2; i >= 0; --i) {
            maxHeapify(a, i, heapSize);
        }
    }

    public void maxHeapify(int[] a, int i, int heapSize) {
        int l = i * 2 + 1, r = i * 2 + 2, largest = i;
        if (l < heapSize && a[l] > a[largest]) {
            largest = l;
        }
        if (r < heapSize && a[r] > a[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(a, i, largest);
            maxHeapify(a, largest, heapSize);
        }
    }

    //丢排序 end

    //交换位置
    private void swap(int[] nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
