package com.review;

import java.util.ArrayList;
import java.util.List;

//448. Find All Numbers Disappeared in an Array
public class Q448 {
    public static void main(String[] args) {
        Q448  test=new Q448();
        int[] nums=new int[]{4,3,2,7,8,2,3,1};
        test.findDisappearedNumbers(nums);
    }
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result=new ArrayList<>();
        int n=nums.length;
        for (int i = 0; i < nums.length; i++) {
            int x= (nums[i]-1)%n;
            nums[x]+=n;
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<=n) result.add(i+1);
        }
        return result;
    }  
}
