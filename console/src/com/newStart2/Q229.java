package com.newStart2;

import java.util.ArrayList;
import java.util.List;

//摩尔选举
//抵消阶段和计数阶段
public class Q229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        // 初始化两个候选人candidate，和他们的计票
        int cand1 = nums[0], count1 = 0;
        int cand2 = nums[0], count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==cand1) {
                count1++;
                continue;
            }
            if(nums[i]==cand2){
                count2++;
                continue;
            }
            if(count1==0){
                cand1=nums[i];
                count1++;
                continue;
            }

            if(count2==0){
                cand2=nums[i];
                count2++;
                continue;
            }

            count1--;
            count2--;
        }
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (cand1 == num) count1++;
            else if (cand2 == num) count2++;
        }

        if (count1 > nums.length / 3) res.add(cand1);
        if (count2 > nums.length / 3) res.add(cand2);

        return res;
    }
}
