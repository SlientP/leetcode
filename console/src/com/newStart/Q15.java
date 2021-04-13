package com.newStart;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// -2 -2 -1 0 1 2 2 4
public class Q15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        int len= nums.length;
        if(len<3) return result;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if(i>0&&nums[i]==nums[i-1]) continue;
            int k=len-1;
            int target=-nums[i];
            for (int j = i+1; j < len ; j++) {
                if(nums[j]>target) break;
                if(j>i+1&&nums[j]==nums[j-1]) continue;
                while (j<k&&nums[j]+nums[k]>target) k--;
                if(j==k) break;
                if(nums[i]+nums[j]+nums[k]==0){
                    List<Integer> res_item=new ArrayList<Integer>();
                    res_item.add(nums[i]);
                    res_item.add(nums[j]);
                    res_item.add(nums[k]);
                    result.add(res_item);
                }
            }
        }
        return result;
    }
}
