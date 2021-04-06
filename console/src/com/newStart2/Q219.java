package com.newStart2;

import java.util.HashMap;

public class Q219 {
    public static void main(String[] args) {
        Q219 test=new Q219();
        int[] nums=new int[]{1,2,3,1,2,3};
        System.out.println(test.containsNearbyDuplicate(nums,2));
    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int len=nums.length;
        if(len==0) return false;
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < len-i; j++) {
                if(nums[j]==nums[j+i]) return true;
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicateV2(int[] nums, int k) {
        int len=nums.length;
        if(len==0) return false;
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < len; i++) {
            if(map.isEmpty()||!map.containsKey(nums[i])){
                map.put(nums[i],i);
            }else{
                int index=map.get(nums[i]);
                if((i-index)<=k) return true;
                map.put(nums[i],i);
            }
        }
        return false;
    }
}
